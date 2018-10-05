package com.recipes.Services;

import com.recipes.DTO.RecipeDTO;
import com.recipes.Entities.Recipe;

import java.util.List;

public interface IRecipeServices {

    void save(Recipe recipe, long userId);

    List<Recipe> getRecipeDTOList();

    Recipe updateRecipeInfo(int id, RecipeDTO dataToUpdate, int userId);

    void deleteRecipe(int userId, int id);

    Recipe getRecipeById(int id);
}
