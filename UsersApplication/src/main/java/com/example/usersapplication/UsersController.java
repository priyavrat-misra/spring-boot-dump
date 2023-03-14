package com.example.usersapplication;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class UsersController {
    UsersDB db = UsersDB.getInstance();

    @GetMapping("/")
    String welcomeMessage() {
        return "<samp><ul>Welcome to Users Database</ul><li>/user/{id}<li>/users</li></ul></samp>";
    }

    @PostMapping("/users")
    String addUser(@RequestBody User user) {
        /*
          curl --location 'http://localhost:8080/users' \
          --header 'Content-Type: application/json' \
          --data '{
              "name": "xyz",
              "age": 25
          }'
        */
        db.addUser(user);
        return "User added successfully!";
    }

    @GetMapping("/users")
    HashMap<Integer, User> getAllUsers() {
        // curl --location 'http://localhost:8080/users'
        return db.getUsers();
    }

    @GetMapping("/user/{id}")
    User getUserByID(@PathVariable int id) {
        // curl --location 'http://localhost:8080/user/1'
        return db.getUser(id);
    }

}
