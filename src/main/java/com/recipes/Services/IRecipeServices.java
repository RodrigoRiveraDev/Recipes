package com.recipes.Services;

import com.recipes.DTO.RecipeDTO;
import com.recipes.Entities.Recipe;

import java.util.List;

public interface IRecipeServices {

    void save(Recipe recipe);

    List<Recipe> getRecipeDTOList();

    RecipeDTO updateRecipeInfo(int id, RecipeDTO dataToUpdate, int userId);

    void deleteRecipe(int userId, int id);

    RecipeDTO getRecipeById(int id);
}
