package com.recipes.Repositories;

import com.recipes.Entities.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

    /**
     * @return It will retrieve a list with all the registered Ingredients
     */
    List<Ingredient> findAll();

}
