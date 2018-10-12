package com.recipes.Services;

import com.recipes.Entities.Recipe;
import com.recipes.Entities.User;
import com.recipes.Exceptions.ResourceNotFoundException;
import com.recipes.Exceptions.UnauthorizedException;
import com.recipes.Repositories.RecipeRepository;
import com.recipes.Utilitaries.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipes.sharedDomain.DTO.IngredientDTO;
import recipes.sharedDomain.DTO.RecipeDTO;

import java.util.List;

@Service
public class RecipeServices implements IRecipeServices {

    private RecipeRepository recipeRepository;
    private UserServices userServices;

    @Autowired
    public RecipeServices(RecipeRepository recipeRepository, UserServices userServices) {
        this.recipeRepository = recipeRepository;
        this.userServices = userServices;
    }

    /**
     * @param recipe The Recipe entity to be stored in the DB
     * @param userId The user id that request to store the Recipe and its owner
     * @return It will return the Recipe entity stored
     * @throws UnauthorizedException It will be thrown if the user that request to store
     * the Recipe is not registered in the DB
     */
    @Override
    public Recipe save(Recipe recipe, long userId) throws UnauthorizedException {

        try {
            User user = userServices.findUserById(userId);
        } catch (ResourceNotFoundException exception) {
            throw new UnauthorizedException();
        }

        recipe.setUserId(userId);

        return recipeRepository.save(recipe);
    }

    /**
     * @param recipeId the Recipe id to update
     * @param dataToUpdate the data to update
     * @param userId the user id that request to update the Recipe
     * @return It will return the updated Recipe
     * @throws ResourceNotFoundException It will be thrown if the is not a Recipe with the provided id stored
     * @throws UnauthorizedException It will be thrown if the user that request is not the recipe owner
     */
    @Override
    public Recipe updateRecipeInfo(long recipeId, RecipeDTO dataToUpdate, long userId)
            throws ResourceNotFoundException, UnauthorizedException {

        Recipe recipe = recipeRepository.findById(recipeId);

        if(recipe == null) {
            throw new ResourceNotFoundException(Recipe.class, recipeId);
        }

        if(recipe.getUserId() == userId) {
            if(!dataToUpdate.getHowElaborate().isEmpty()) {
                recipe.setHowElaborate(dataToUpdate.getHowElaborate());
            }
            if(dataToUpdate.getIngredients().size() > 0) {
              List<IngredientDTO> ingredientDTOS = dataToUpdate.getIngredients();
                recipe.setIngredients(Factory.toIngredientList(ingredientDTOS));
            }
            recipeRepository.save(recipe);
        } else {
            throw new UnauthorizedException();
        }

        return recipe;
    }

    /**
     * @param userId The user that request to delete the Recipe
     * @param recipeId The recipe id to delete
     * @throws ResourceNotFoundException It will be thrown if the is not a Recipe with the provided id stored
     * @throws UnauthorizedException It will be thrown if the user that request is not the recipe owner
     */
    @Override
    public void deleteRecipe(long userId, long recipeId)
            throws ResourceNotFoundException, UnauthorizedException {

        Recipe recipe = recipeRepository.findById(recipeId);

        if(recipe == null) {
            throw new ResourceNotFoundException(Recipe.class, recipeId);
        }

        if(recipe.getUserId() != userId) {
            throw new UnauthorizedException();
        }

        recipeRepository.delete(recipe);
    }

    /**
     * @param id The recipe id to search in the DB
     * @return It will return the Recipe entity
     * @throws ResourceNotFoundException It will be thrown if there is not a Recipe with the provided id stored
     */
    @Override
    public Recipe getRecipeById(long id) throws ResourceNotFoundException  {

        Recipe recipe = recipeRepository.findById(id);

        if(recipe == null) {
            throw new ResourceNotFoundException(Recipe.class, id);
        }

        return recipe;
    }

    /**
     * @return It will retrieve a list with all the stored Recipes
     */
    @Override
    public List<Recipe> getRecipeDTOList() {
        return recipeRepository.findAll();
    }
}
