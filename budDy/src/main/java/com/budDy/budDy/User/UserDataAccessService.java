package com.budDy.budDy.User;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDataAccessService {
    private static List<User> userDB;

    public UserDataAccessService(){
        User user1 = new User("lizzieDearden", "lizzied@live.com", "123", UserExperience.BEGINNER, 2);
        User user2 = new User("stephRost", "stephR@google.com", "abc", UserExperience.ADVANCED, 1);

    userDB = new ArrayList<>();
        userDB.add(user1);
        userDB.add(user2);
    }

    public List<User> listAllUsers() {
        return userDB;
    }

    public void insertUser(User user) {
        userDB.add(user);
    }

    public void deleteUser(User user) {
        userDB.remove(user);
    }

}
