package com.budDy.budDy.User;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "bud-dy/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> listUsers() {
        return userService.listUsers();
    }

    @PostMapping
    public void addNewUser(@RequestBody User user) {
        System.out.println(user);
        userService.addNewUser(user);
    }

    @DeleteMapping("{userName}")
    public void deleteUser(@PathVariable("userName") String userName) {
        userService.removeUser(userName);
    }

}
