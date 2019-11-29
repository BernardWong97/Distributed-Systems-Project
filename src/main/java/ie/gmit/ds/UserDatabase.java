package ie.gmit.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserDatabase {
    private static HashMap<Integer, User> usersMap = new HashMap<>();

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
