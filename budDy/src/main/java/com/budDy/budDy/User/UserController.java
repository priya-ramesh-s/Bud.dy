package com.budDy.budDy.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "buddy/users")
public class UserController {

      private UserService userService;

      @Autowired
      public UserController(UserService userService) {
        this.userService = userService; }


     @GetMapping
     public List<User> getUsers() {
        return userService.getUsers();}

    @PostMapping
    public void addUser(@RequestBody User user) {
          userService.addUser(user);}


    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }

    @PutMapping
    public void updateUser(@PathVariable("userId") Long userId, @RequestBody User user){
          userService.updateUser(userId, user);
    }
}
