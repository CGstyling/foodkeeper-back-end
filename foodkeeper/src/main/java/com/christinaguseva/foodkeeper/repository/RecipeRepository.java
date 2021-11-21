package com.christinaguseva.foodkeeper.repository;

import com.christinaguseva.foodkeeper.model.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
