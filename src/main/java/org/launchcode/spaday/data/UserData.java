package org.launchcode.spaday.data;

import org.launchcode.spaday.models.User;

import java.util.ArrayList;

public class UserData {

    private static final ArrayList<User> users = new ArrayList<>();

    public static void add(User user) {
        users.add(user);
    }

    public static User getById(int id) {
        for (User user : users)
            if (user.getId() == id) {
                return user;
            }
        return null;
    }

    public static ArrayList<User> getAll() {
        return users;
    }

}
