package ie.gmit.ds;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.ArrayList;
import java.util.Set;

/**
 * Resource class for User API.
 * Adapted from https://howtodoinjava.com/dropwizard/tutorial-and-hello-world-example
 */
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserApiResource {
    private final Validator validator;
    private PasswordClient passwordClient;
    private final String HOST = "localhost";
    private final int PORT = 50551;

    /**
     * Initialize validator and password client.
     *
     * @param validator validator
     */
    public UserApiResource(Validator validator) {
        this.validator = validator;
        this.passwordClient = new PasswordClient(HOST, PORT);
    }

    /**
     * Return all users from the database.
     *
     * @return a core response of all users
     */
    @GET
    public Response getUsers() {
        return Response.ok(UserDatabase.getUsers()).build();
    }

    /**
     * Return a user by id.
     *
     * @param id id
     * @return a core response of either the user of the id or "User Not Found!"
     */
    @GET
    @Path("/{userId}")
    public Response getUserById(@PathParam("userId") Integer id) {
        if (UserDatabase.getUser(id) != null)
            return Response.ok(UserDatabase.getUser(id)).build();
        else
            return Response.status(Status.NOT_FOUND).entity("User Not Found!").build();
    }

    /**
     * Create a user and add into the database.
     *
     * @param user the user to be create
     * @return "User already exists" if the user exists in the database.
     *         "User successfully added!" if the user is created successfully.
     *         validation error message if error in validation occurs.
     */
    @POST
    public Response addUser(User user) {
        System.out.println("This is the user from postman: " + user.toString());
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

    /**
     * Delete a user from the database by id
     *
     * @param id id
     * @return "User successfully deleted!" if user is deleted.
     *         "User Not Found!" if user does not exist in the database.
     */
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

    /**
     * Update a user in the database.
     *
     * @param id id
     * @param user the user to be update
     * @return "User not found" if the user does not exist in the database.
     *         "User successfully updated!" if the user is updated successfully.
     *         validation error message if error in validation occurs.
     */
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

    /**
     * Login a user and validate password.
     *
     * @param userLogin user input login object
     * @return "User successfully logged in!" if password is correct.
     *         "Invalid Password!" if password is incorrect.
     *         "User Not Found!" if user does not exist in the database.
     *         validation error message if error in validation occurs.
     */
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
