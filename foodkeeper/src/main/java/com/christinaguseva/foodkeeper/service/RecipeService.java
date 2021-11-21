package com.christinaguseva.foodkeeper.service;

import com.christinaguseva.foodkeeper.exception.RecordNotFoundException;
import com.christinaguseva.foodkeeper.model.Recipe;
import com.christinaguseva.foodkeeper.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Iterable<Recipe> findAll() {
        Iterable<Recipe> recipes = recipeRepository.findAll();
        return recipes;
    }

    public Recipe findById(long nr) {
        Optional<Recipe> recipe = recipeRepository.findById(nr);
        if (recipe.isPresent()) {
            return recipe.get();
        }
        else {
            throw new RecordNotFoundException("Speler with id " + nr + " not found");
        }
    }

    public void save(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    public void deleteById(long nr) {
        try {
            recipeRepository.deleteById(nr);
        }
        catch (IndexOutOfBoundsException ex) {
            System.out.println(ex);
            throw new RecordNotFoundException();
        }
    }
}
