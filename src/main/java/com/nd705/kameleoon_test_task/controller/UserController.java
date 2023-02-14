package com.nd705.kameleoon_test_task.controller;

import com.nd705.kameleoon_test_task.entity.User;
import com.nd705.kameleoon_test_task.service.UserService;
import com.nd705.kameleoon_test_task.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        userService.saveUser(user);
        return user;
    }

    @GetMapping("/users")
    public List<User> showAllUsers(){
        List<User> allUsers = userService.getAllUsers();
        return allUsers;
    }

    //TO DO
//    @PostMapping("/addQuote")
//
//    @GetMapping("/getQuote")
//
//    @GetMapping("/getRandomQuote")
//
//    @PutMapping("/editQuote")
//
//    @DeleteMapping("/deleteQuote")
//
//    @PutMapping("/voteForAQuote")
//
//    @GetMapping("/getTop")
//
//    @GetMapping("/getWorse")





}
