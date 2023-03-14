package com.example.usersapplication;

import java.util.HashMap;

public class UsersDB {
    private final HashMap<Integer, User> table = new HashMap<>();
    private static final UsersDB db = new UsersDB();

    private UsersDB() {}

    static UsersDB getInstance() {
        return db;
    }

    User getUser(int id) {
        return table.get(id);
    }

    void addUser(User user) {
    	table.put(User.id, user);
    }

    HashMap<Integer, User> getUsers() {
        return table;
    }
    
}
