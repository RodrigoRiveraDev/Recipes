package com.recipes.Repositories;

import com.recipes.Entities.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    Recipe findById(long id);

    @Query("SELECT r FROM Recipe r")
    List<Recipe> findAll();
}
