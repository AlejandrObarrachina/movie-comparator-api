package com.moviesapi.moviesapi.controller;

import com.moviesapi.moviesapi.model.UserData;
import com.moviesapi.moviesapi.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserRepository repo;
    public UserController(UserRepository repo) {
        this.repo = repo;
    }
    @GetMapping(value = "/users")
    private List<UserData> getAllUsers(){
        return repo.findAll();
    }

    @PostMapping("/users")
    private void addUser(@RequestBody UserData userData){
        repo.insert(userData);
    }


}
