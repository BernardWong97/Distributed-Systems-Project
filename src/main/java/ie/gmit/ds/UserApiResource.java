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
}
