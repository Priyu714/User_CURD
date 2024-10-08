package com.example.Helloword.service;

import com.example.Helloword.model.User;
import com.example.Helloword.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public List<User> getAllUser(){
        return userRepo.findAll();
    }

    public User getAllUserById(Integer id){
        return userRepo.findById(id).get();
    }

    public User createUser(User user){
        return userRepo.save(user);
    }

    public String deleteUser(Integer id){
        userRepo.deleteById(id);
        return  id + " is deleted Successfully ";
    }

    public User updateUserById(Integer id, User user) {
        if (id != null && userRepo.existsById(id)) {
            User existingUser = userRepo.findById(id).orElseThrow(() ->
                                new RuntimeException("User not found"));
            existingUser.setName(user.getName());
            existingUser.setAddress(user.getAddress());
            return userRepo.save(existingUser);
        } else {
            throw new RuntimeException("Invalid ID or user data");
        }
    }


}
