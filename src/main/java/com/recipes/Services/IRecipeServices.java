package com.recipes.Services;

import com.recipes.DTO.Recipe;

import java.util.List;

public interface IRecipeServices {

    void save(Recipe recipe);

    List<Recipe> getRecipeList();

    Recipe updateRecipeInfo(int id, Recipe dataToUpdate, int userId);

    void deleteRecipe(int userId, int id);

    Recipe getRecipeById(int id);
}
