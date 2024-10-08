package com.example.Helloword;

import com.example.Helloword.model.User;
import com.example.Helloword.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class Controller {

    @Autowired
    UserService userService;

    @GetMapping("/hello/{str}")
    public String displayMethod(@PathVariable String str){
        return "Hello Word "+str;
    }
    //http://localhost:9090/user/getAllUser

    @GetMapping("/getAllUser")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    //localhost:9090/user/getUserById
    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable Integer id){
        return userService.getAllUserById(id);
    }

    //localhost:9090/user/createUser
    @PostMapping("/createUser")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    //localhost:9090/user/deleteUser
    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Integer id){
        return userService.deleteUser(id);
    }

    @PutMapping("/updateUser/{id}")
    public User updateUser(@PathVariable Integer id,@RequestBody User user){
        return userService.updateUserById(id,user);
    }
}
