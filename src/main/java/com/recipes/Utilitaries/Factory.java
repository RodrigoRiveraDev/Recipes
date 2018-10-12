package com.recipes.Utilitaries;

import com.recipes.DTO.RecipeDTO;
import com.recipes.Entities.Recipe;

public class Factory {

    /**
     * @param recipe Recipe entity to transform to RecipeDTO
     * @return It will return the RecipeDTO from the provided Recipe
     */
    public static RecipeDTO recipeDTO(Recipe recipe) {
        return new RecipeDTO(recipe.getIngredients(), recipe.getHowElaborate());
    }
}
