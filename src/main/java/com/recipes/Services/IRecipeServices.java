package com.recipes.Services;

import com.recipes.DTO.RecipeDTO;
import com.recipes.Entities.Recipe;
import com.recipes.Exceptions.ResourceNotFoundException;
import com.recipes.Exceptions.UnauthorizedException;

import java.util.List;

public interface IRecipeServices {

    /**
     * @param recipe The Recipe entity to be stored in the DB
     * @param userId The user id that request to store the Recipe and its owner
     * @return It will return the Recipe entity stored
     * @throws UnauthorizedException It will be thrown if the user that request to store
     * the Recipe is not registered in the DB
     */
    Recipe save(Recipe recipe, long userId) throws UnauthorizedException;

    /**
     * @return It will retrieve a list with all the stored Recipes
     */
    List<Recipe> getRecipeDTOList();

    /**
     * @param recipeId the Recipe id to udpate
     * @param dataToUpdate the data to update
     * @param userId the user id that request to update the Recipe
     * @return It will return the updated Recipe
     * @throws ResourceNotFoundException It will be thrown if the is not a Recipe with the provided id stored
     * @throws UnauthorizedException It will be thrown if the user that request is not the recipe owner
     */
    Recipe updateRecipeInfo(long recipeId, RecipeDTO dataToUpdate, long userId)
            throws ResourceNotFoundException, UnauthorizedException;

    /**
     * @param userId The user that request to delete the Recipe
     * @param recipeId The recipe id to delete
     * @throws ResourceNotFoundException It will be thrown if the is not a Recipe with the provided id stored
     * @throws UnauthorizedException It will be thrown if the user that request is not the recipe owner
     */
    void deleteRecipe(long userId, long recipeId) throws ResourceNotFoundException, UnauthorizedException;

    /**
     * @param id The recipe id to search in the DB
     * @return It will return the Recipe entity
     * @throws ResourceNotFoundException It will be thrown if there is not a Recipe with the provided id stored
     */
    Recipe getRecipeById(long id) throws ResourceNotFoundException;
}
