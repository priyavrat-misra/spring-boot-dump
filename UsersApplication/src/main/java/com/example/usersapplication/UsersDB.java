package com.example.usersapplication;

import java.util.HashMap;

public class UsersDB {
    private HashMap<Integer, User> table = new HashMap<>();
    private UsersDB() {
        table.put(1, new User("abc", 25));
        table.put(2, new User("xyz", 24));
    }
    private static UsersDB db = new UsersDB();
    static UsersDB getInstance() {
        return db;
    }
    User getUser(int id) {
        return table.get(id);
    }
    HashMap<Integer, User> getUsers() {
        return table;
    }
}
