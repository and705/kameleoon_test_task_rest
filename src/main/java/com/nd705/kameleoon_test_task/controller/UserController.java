package com.nd705.kameleoon_test_task.controller;

import com.nd705.kameleoon_test_task.entity.Quote;
import com.nd705.kameleoon_test_task.entity.User;
import com.nd705.kameleoon_test_task.service.QuoteService;
import com.nd705.kameleoon_test_task.service.UserService;
import com.nd705.kameleoon_test_task.service.UserServiceImpl;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private QuoteService quoteService;

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


    @PostMapping("/quotes")
    public Quote addQuote(@RequestBody Quote quote){
        quoteService.saveQuote(quote);
        return quote;
    }

    @GetMapping("/quotes/{id}")
    public String getQuote(@PathVariable int id){
        Quote quote = quoteService.getQuote(id);
        return quote.toString();
    }

    @DeleteMapping("/quotes/{id}")
    public String deleteQuote(@PathVariable int id){

        quoteService.deleteQuote(id);
        return "Quote with ID = " + id + " was deleted";

    }

    @GetMapping("/getRandomQuote")
    public String getRandomQuote(){
        Quote quote = quoteService.getRandomQuote();
        return quote.toString();
    }

    @PutMapping("/quotes")
    public Quote updateQuote(@RequestBody Quote quote) {
        quoteService.saveQuote(quote);
        return quote;
    }


    @PutMapping("/quotes/vote")
    public String voteUpQuote(@RequestParam int userId, @RequestParam int quoteId, @RequestParam boolean voteUp){
        quoteService.voteQuote(userId, quoteId, voteUp);
        return "voteUpQuote done";
    }


    @GetMapping("/getTop10")
    public String getTop10(){
        return quoteService.getTop(10).toString();
    }

    @GetMapping("/getWorse10")
    public String getWorse10(){
        return quoteService.getWorse(10).toString();
    }





}
