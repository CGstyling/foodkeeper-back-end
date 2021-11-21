package com.christinaguseva.foodkeeper.service;

import com.christinaguseva.foodkeeper.exception.RecordNotFoundException;
import com.christinaguseva.foodkeeper.model.Recipe;
import com.christinaguseva.foodkeeper.model.User;
import com.christinaguseva.foodkeeper.repository.RecipeRepository;
import com.christinaguseva.foodkeeper.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RecipeRepository recipeRepository;

    @Autowired
    public UserService(UserRepository userRepository, RecipeRepository recipeRepository) {
        this.userRepository = userRepository;
        this.recipeRepository = recipeRepository;
    }

    public Iterable<User> findAll() {
        Iterable<User> users = userRepository.findAll();
        return users;
    }

    public User findById(long nr) {
        Optional<User> user = userRepository.findById(nr);
        if (user.isPresent()) {
            return user.get();
        }
        else {
            throw new RecordNotFoundException("Team with id " + nr + " not found");
        }
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void deleteById(long nr) {
        try {
            userRepository.deleteById(nr);
        }
        catch (IndexOutOfBoundsException ex) {
            System.out.println(ex);
            throw new RecordNotFoundException();
        }
    }

    public Iterable<Recipe> getUserRecipes(long nr) {
        Optional<User> user = userRepository.findById(nr);
        if (user.isPresent()) {
            return user.get().getRecipes();
        }
        else {
            throw new RecordNotFoundException("Team with id " + nr + " not found");
        }
    }
}
