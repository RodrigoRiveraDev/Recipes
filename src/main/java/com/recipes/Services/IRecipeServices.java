package com.recipes.Services;

import com.recipes.DTO.RecipeDTO;
import com.recipes.Entities.Recipe;
import com.recipes.Exceptions.ResourceNotFoundException;
import com.recipes.Exceptions.UnauthorizedException;

import java.util.List;

public interface IRecipeServices {

    Recipe save(Recipe recipe, long userId) throws UnauthorizedException;

    List<Recipe> getRecipeDTOList();

    Recipe updateRecipeInfo(int id, RecipeDTO dataToUpdate, int userId)
            throws ResourceNotFoundException, UnauthorizedException;

    void deleteRecipe(int userId, int id) throws ResourceNotFoundException, UnauthorizedException;

    Recipe getRecipeById(int id) throws ResourceNotFoundException;
}
