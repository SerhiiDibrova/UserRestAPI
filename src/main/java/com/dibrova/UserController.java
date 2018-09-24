package com.dibrova;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    public User getId(@PathVariable int id) {
        return userService.getId(id);
    }

    @PostMapping("/users/add")
    public void addUsers(@RequestBody User user) {
        userService.addUser(user);

    }


    @PutMapping(value = "/users/{id}")
    public void update(@RequestBody User user, @PathVariable int id) {
        userService.updateUsers(id, user);

    }

    @DeleteMapping(value = "/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
