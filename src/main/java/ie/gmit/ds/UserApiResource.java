package ie.gmit.ds;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.ArrayList;
import java.util.Set;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserApiResource {
    private final Validator validator;
    private PasswordClient passwordClient;
    private final String HOST = "localhost";
    private final int PORT = 50551;

    public UserApiResource(Validator validator) {
        this.validator = validator;
        this.passwordClient = new PasswordClient(HOST, PORT);
    }

    @GET
    public Response getUsers() {
        return Response.ok(UserDatabase.getUsers()).build();
    }

    @GET
    @Path("/{userId}")
    public Response getUserById(@PathParam("userId") Integer id) {
        if (UserDatabase.getUser(id) != null)
            return Response.ok(UserDatabase.getUser(id)).build();
        else
            return Response.status(Status.NOT_FOUND).entity("User Not Found!").build();
    }

    @POST
    public Response addUser(User user) {
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        User u = UserDatabase.getUser(user.getUserId());

        if (violations.size() > 0) {
            ArrayList<String> validationMsg = new ArrayList<>();
            for (ConstraintViolation<User> violation : violations)
                validationMsg.add(violation.getPropertyPath().toString());

            return Response.status(Status.BAD_REQUEST).entity(validationMsg).build();
        }

        if (u == null) {
            passwordClient.hash(user);
            return Response.status(Status.OK).entity("User successfully added!").build();
        } else {
            return Response.status(Status.CONFLICT).entity("User already exists!").build();
        }
    }

    @DELETE
    @Path("/{userId}")
    public Response deleteUser(@PathParam("userId") Integer id) {
        if (UserDatabase.getUser(id) != null) {
            UserDatabase.deleteUser(id);
            return Response.status(Status.OK).entity("User successfully deleted!").build();
        } else {
            return Response.status(Status.NOT_FOUND).entity("User Not Found!").build();
        }
    }

    @PUT
    @Path("/{userId}")
    public Response updateUser(@PathParam("userId") Integer id, User user) {
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        User u = UserDatabase.getUser(user.getUserId());

        if (violations.size() > 0) {
            ArrayList<String> validationMsg = new ArrayList<>();
            for (ConstraintViolation<User> violation : violations)
                validationMsg.add(violation.getPropertyPath().toString());

            return Response.status(Status.BAD_REQUEST).entity(validationMsg).build();
        }

        if (u != null) {
            UserDatabase.updateUser(id, user);
            passwordClient.hash(user);
            return Response.status(Status.OK).entity("User successfully updated!").build();
        } else {
            return Response.status(Status.NOT_FOUND).entity("User Not Found!").build();
        }
    }

    @PUT
    @Path("/login")
    public Response validateUser(UserLogin userLogin) {
        Set<ConstraintViolation<UserLogin>> violations = validator.validate(userLogin);
        User u = UserDatabase.getUser(userLogin.getUserId());

        if (violations.size() > 0) {
            ArrayList<String> validationMsg = new ArrayList<>();
            for (ConstraintViolation<UserLogin> violation : violations)
                validationMsg.add(violation.getPropertyPath().toString());

            return Response.status(Status.BAD_REQUEST).entity(validationMsg).build();
        }

        if (u != null) {
           if(passwordClient.validatePassword(userLogin.getPassword(), u.getSalt(), u.getHashedPassword()))
                return Response.status(Status.OK).entity("User successfully logged in!").build();
           else
               return Response.status(Status.NOT_FOUND).entity("Invalid Password!").build();
        } else {
            return Response.status(Status.NOT_FOUND).entity("User Not Found!").build();
        }
    }
}
