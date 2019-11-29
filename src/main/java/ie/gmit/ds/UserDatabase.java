package ie.gmit.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserDatabase {
    private static HashMap<Integer, User> usersMap = new HashMap<>();

    public UserDatabase() {
        User user1 = new User(1, "test1", "test@email.com", "testpw");
        User user2 = new User(2, "testsubject", "testmail@email.com", "password123");
        User user3 = new User(3, "Bernard", "emailtest@email.com", "pw512");
        usersMap.put(user1.getUserId(), user1);
        usersMap.put(user2.getUserId(), user2);
        usersMap.put(user3.getUserId(), user3);
    }

    public static List<User> getUsers() {
        return new ArrayList<>(usersMap.values());
    }

    public static User getUser(int id) {
        return usersMap.get(id);
    }

    public static void createUser(int id, User user) {
        usersMap.put(id, user);
    }

    public static void updateUser(int id, User user) {
        usersMap.replace(id, user);
    }

    public static void deleteUser(int id) {
        usersMap.remove(id);
    }
}
