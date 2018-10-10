package com.recipes.Utilitaries;

import com.recipes.DTO.RecipeDTO;
import com.recipes.Entities.Recipe;

public class Factory {

    public static RecipeDTO recipeDTO(Recipe recipe) {
        return new RecipeDTO(recipe.getIngredients(), recipe.getHowElaborate());
    }
}
