package com.christinaguseva.foodkeeper.controller;

import com.christinaguseva.foodkeeper.model.Recipe;
import com.christinaguseva.foodkeeper.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping(value = "/recipes")
    public ResponseEntity getRecipes() {
        Iterable<Recipe> recipes;
        recipes = recipeService.findAll();
        return ResponseEntity.ok(recipes);
    }

    @GetMapping(value = "/recipes/{nr}")
    public ResponseEntity getRecipe(@PathVariable long nr) {
        Recipe recipe = recipeService.findById(nr);
        return ResponseEntity.ok(recipe);
    }

    @PostMapping(value = "/recipes")
    public ResponseEntity addRecipe(@RequestBody Recipe recipe) {
        recipeService.save(recipe);
        return ResponseEntity.ok("Toegevoegd");
    }

    @DeleteMapping(value = "/recipes/{nr}")
    public ResponseEntity deleteRecipe(@PathVariable long nr) {
        recipeService.deleteById(nr);
        return ResponseEntity.ok("Verwijderd");
    }

    @PutMapping(value = "/recipes/{nr}")
    public ResponseEntity updateRecipe(@PathVariable long nr, @RequestBody Recipe recipe) {
        return ResponseEntity.ok("Aangepast");
    }

}
