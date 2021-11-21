package com.christinaguseva.foodkeeper.controller;

import com.christinaguseva.foodkeeper.model.Recipe;
import com.christinaguseva.foodkeeper.model.User;
import com.christinaguseva.foodkeeper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public ResponseEntity getUsers() {
        Iterable<User> users;
        users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping(value = "/users/{nr}")
    public ResponseEntity getUser(@PathVariable long nr) {
        User user = userService.findById(nr);
        return ResponseEntity.ok(user);
    }

    @PostMapping(value = "/users")
    public ResponseEntity addUser(@RequestBody User user) {
        userService.save(user);
        return ResponseEntity.ok("Toegevoegd");
    }

    @DeleteMapping(value = "/users/{nr}")
    public ResponseEntity deleteUser(@PathVariable long nr) {
        userService.deleteById(nr);
        return ResponseEntity.ok("Verwijderd");
    }

    @PutMapping(value = "/users/{nr}")
    public ResponseEntity updateUser(@PathVariable long nr, @RequestBody User user) {
        return ResponseEntity.ok("Aangepast");
    }

    @GetMapping(value = "/users/{nr}/recipes")
    public ResponseEntity getUserRecipes(@PathVariable long nr) {
        Iterable<Recipe> userRecipes = userService.getUserRecipes(nr);
        return ResponseEntity.ok(userRecipes);
    }
}
