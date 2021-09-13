package com.budDy.budDy.User;

import com.budDy.budDy.Plant.Plant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserDataAccessService userDataAccessService;

    public UserService(UserDataAccessService userDataAccessService){
        this.userDataAccessService = userDataAccessService;
    }

    public List<User> listUsers() {
        return userDataAccessService.listAllUsers();
    }

    public void addNewUser(User user){
        userDataAccessService.insertUser(user);
    }

    public void removeUser(String userName){
        List<User> users = userDataAccessService.listAllUsers();
        boolean exists = false;
        for (User u: users) {
            if(u.getUserName().equals(userName)){
                exists = true;
                userDataAccessService.deleteUser(u);
            }
        }
        if (!exists) {
            throw new IllegalStateException(userName + " was not found so cannot be removed.");
        }
    }
}
