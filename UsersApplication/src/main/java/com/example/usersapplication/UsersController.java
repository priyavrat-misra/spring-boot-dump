package com.example.usersapplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class UsersController {
    UsersDB db = UsersDB.getInstance();

    @GetMapping("/")
    String welcomeMessage() {
        return "<samp><ul>Welcome to Users Database</ul><li>/user/{id}<li>/users</li></ul></samp>";
    }

    @GetMapping("/user/{id}")
    User getUserByID(@PathVariable int id) {
        return db.getUser(id);
    }

    @GetMapping("/users")
    HashMap<Integer, User> getAllUsers() {
        return db.getUsers();
    }
}
