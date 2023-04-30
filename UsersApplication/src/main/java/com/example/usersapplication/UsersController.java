package com.example.usersapplication;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
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
    String addUser(@RequestBody @Valid User user) {
        /*
         * curl -X POST 'http://localhost:1234/users' \
         * --header 'Content-Type: application/json' \
         * --data '{"name": "xyz", "age": 25}'
         */
        db.addUser(user);
        return "User added successfully!";
    }

    @GetMapping("/users")
    HashMap<Integer, User> getAllUsers() {
        /*
         * curl -X GET 'http://localhost:1234/users'
         */
        return db.getUsers();
    }

    @GetMapping("/users/{id}")
    User getUserByID(@PathVariable int id) {
        /*
         * curl -X GET 'http://localhost:1234/users/1'
         */
        User user = db.getUser(id);
        if (user == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return user;
    }

    @DeleteMapping("/users/{id}")
    // @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.GONE)
    String deleteUser(@PathVariable int id) {
        /*
         * curl -X DELETE 'http://localhost:1234/users/1'
         */
        User user = db.deleteUser(id);
        if (user == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return "User deleted successfully!";
    }

}
