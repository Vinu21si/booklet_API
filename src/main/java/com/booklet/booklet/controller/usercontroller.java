package com.booklet.booklet.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.booklet.booklet.entity.User;
import com.booklet.booklet.service.user_service;



@RestController
@RequestMapping("/user")
public class usercontroller {

    @Autowired
    private user_service user_service;
    @GetMapping
    public List<User> getallUserList(){
        return user_service.getAllUsers();
    }
    
    @PostMapping
    public void createUser(@RequestBody User user){
        user_service.saveUser(user);
    }

    @PutMapping("/{username}")
    public ResponseEntity<?>updateUser(@RequestBody User user, @PathVariable String username){
       User userindb= user_service.findByUsername(username);
       if(userindb!=null){
        userindb.setUsername(user.getUsername());
        userindb.setPassword(user.getPassword());
        user_service.saveUser(userindb);
       }
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
