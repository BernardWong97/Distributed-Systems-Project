package ie.gmit.ds;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.HashMap;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserApiResource {
    private HashMap<Integer, User> usersMap = new HashMap<>();

    public UserApiResource() {
        User testUser = new User(1, "Dummy", "test@email.com", "password");
        usersMap.put(testUser.getUserId(), testUser);
    }

    @GET
    public Collection<User> getUsers() {
        return usersMap.values();
    }

    @GET
    @Path("/{userId}")
    public User getUserById(@PathParam("userId") Integer id) {
        return usersMap.get(id);
    }

    @POST
    public Collection<User> addUser(User user) {
        usersMap.put(user.getUserId(), user);
        return usersMap.values();
    }

    @DELETE
    @Path("/delete")
    public void deleteUser(User user) {
        usersMap.remove(user.getUserId());
    }

    @PUT
    @Path("/update")
    public void updateUser(User user) {
        if(usersMap.containsKey(user.getUserId())) {
            usersMap.replace(user.getUserId(), user);
        } else {
            System.out.println("failed");
        }
    }
}
