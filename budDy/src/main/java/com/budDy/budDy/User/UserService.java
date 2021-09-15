package com.budDy.budDy.User;

import com.budDy.budDy.Plant.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //returns a list of users from db
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void addUser(User user){
        Optional<User> userOptional = userRepository.getUserById(user.getId());
        if (userOptional.isPresent()){
            throw new IllegalStateException("User already exists");
        }
        userRepository.save(user);
        System.out.println(user);
    }

    public void deleteUser(Long userId){
        boolean existsById = userRepository.existsById(userId);
        if(!existsById){
            throw new IllegalStateException("User ID"+ userId + "was not found, so cannot be removed");
        } else {
            userRepository.deleteById(userId);
        }
    }


     // need to create method to search for a new user

     public void updateUser(Long userId, User user) {
     }

}






//public class UserService {
//    private UserDataAccessService userDataAccessService;
//
//    public UserService(UserDataAccessService userDataAccessService){
//        this.userDataAccessService = userDataAccessService;
//    }
//
//    public List<User> listUsers() {
//        return userDataAccessService.listAllUsers();
//    }
//
//    public void addNewUser(User user){
//        userDataAccessService.insertUser(user);
//    }
//
//    public void removeUser(String userName){
//        List<User> users = userDataAccessService.listAllUsers();
//        boolean exists = false;
//        for (User u: users) {
//            if(u.getUserName().equals(userName)){
//                exists = true;
//                userDataAccessService.deleteUser(u);
//            }
//        }
//        if (!exists) {
//            throw new IllegalStateException(userName + " was not found so cannot be removed.");
//        }
//    }
//}
