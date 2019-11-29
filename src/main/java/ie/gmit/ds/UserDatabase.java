package ie.gmit.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A "Fake" database for storing the users using hash-map.
 */
public class UserDatabase {
    private static HashMap<Integer, User> usersMap = new HashMap<>();

    /**
     * Initial testing generate dummy users.
     */
    static {
        User user1 = new User(1, "test1", "test@email.com", "testpw");
        User user2 = new User(2, "testsubject", "testmail@email.com", "password123");
        User user3 = new User(3, "Bernard", "emailtest@email.com", "pw512");
        usersMap.put(user1.getUserId(), user1);
        usersMap.put(user2.getUserId(), user2);
        usersMap.put(user3.getUserId(), user3);
        System.out.println("DONE INITIALIZATION");
    }

    /**
     * @return a list of all users.
     */
    public static List<User> getUsers() {
        return new ArrayList<>(usersMap.values());
    }

    /**
     * @param id id
     * @return a user by id.
     */
    public static User getUser(int id) {
        return usersMap.get(id);
    }

    /**
     * Add a user into the hash-map.
     * @param id id
     * @param user user to be added
     */
    public static void createUser(int id, User user) {
        usersMap.put(id, user);
    }

    /**
     * Update an existing user in the hash-map.
     * @param id id
     * @param user user to be updated
     */
    public static void updateUser(int id, User user) {
        usersMap.replace(id, user);
    }

    /**
     * Delete an existing user from the hash-map by id.
     * @param id id
     */
    public static void deleteUser(int id) {
        usersMap.remove(id);
    }
}
