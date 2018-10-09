package com.recipes.Services;

import com.recipes.DTO.RecipeDTO;
import com.recipes.Entities.Recipe;

import java.util.List;

public interface IRecipeServices {

    Recipe save(Recipe recipe, long userId) throws Exception;

    List<Recipe> getRecipeDTOList();

    Recipe updateRecipeInfo(int id, RecipeDTO dataToUpdate, int userId) throws Exception ;

    void deleteRecipe(int userId, int id) throws Exception ;

    Recipe getRecipeById(int id) throws Exception ;
}
