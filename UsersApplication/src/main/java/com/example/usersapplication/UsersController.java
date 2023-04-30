package com.example.usersapplication;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class UsersController {
    UsersDB db = UsersDB.getInstance();

    @GetMapping("/")
    // @RequestMapping(value = "/", method = RequestMethod.GET)
    String welcomeMessage() {
        return "<samp><ul>Welcome to Users Database</ul><li>/users/{id}<li>/users</li></ul></samp>";
    }

    @PostMapping("/users")
    // @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    String addUser(@RequestBody User user) {
        /*
          curl --location 'http://localhost:1234/users' \
          --header 'Content-Type: application/json' \
          --data '{"name": "xyz", "age": 25}'
        */
        db.addUser(user);
        return "User added successfully!";
    }

    @GetMapping("/users")
    HashMap<Integer, User> getAllUsers() {
        // curl --location 'http://localhost:1234/users'
        return db.getUsers();
    }

    @GetMapping("/users/{id}")
    User getUserByID(@PathVariable int id) {
        // curl --location 'http://localhost:1234/users/1'
        return db.getUser(id);
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.GONE)
    String deleteUser(@PathVariable int id) {
        db.deleteUser(id);
        return "User deleted successfully!";
    }

}
