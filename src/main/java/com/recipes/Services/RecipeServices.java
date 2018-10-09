package com.recipes.Services;

import com.recipes.DTO.RecipeDTO;
import com.recipes.Entities.Recipe;
import com.recipes.Entities.User;
import com.recipes.Exceptions.ResourceNotFoundException;
import com.recipes.Exceptions.UnauthorizedException;
import com.recipes.Repositories.RecipeRepository;
import com.recipes.Utilitaries.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public Recipe save(Recipe recipe, long userId) throws Exception {

        User user = userServices.findUserById(userId);

        if(user == null) {
            throw new UnauthorizedException();
        }

        recipe.setUserId(userId);

        return recipeRepository.save(recipe);
    }

    @Override
    public Recipe updateRecipeInfo(int recipeId, RecipeDTO dataToUpdate, int userId) throws Exception {

        Recipe recipe = recipeRepository.findById(recipeId);

        if(recipe == null) {
            throw new ResourceNotFoundException(Recipe.class, recipeId);
        }

        if(recipe.getUserId() == userId) {
            if(!dataToUpdate.getHowElaborate().isEmpty()) {
                recipe.setHowElaborate(dataToUpdate.getHowElaborate());
            }
            if(dataToUpdate.getIngredients().size() > 0) {
                recipe.setIngredients(Factory.toIngredientsList(dataToUpdate.getIngredients()));
            }
            recipeRepository.save(recipe);
        } else {
            throw new UnauthorizedException();
        }

        return recipe;
    }

    @Override
    public void deleteRecipe(int userId, int recipeId) throws Exception {

        Recipe recipe = recipeRepository.findById(recipeId);

        if(recipe == null) {
            throw new ResourceNotFoundException(Recipe.class, recipeId);
        }

        if(recipe.getUserId() != userId) {
            throw new UnauthorizedException();
        }

        recipeRepository.delete(recipe);
    }

    @Override
    public Recipe getRecipeById(int id) throws Exception  {

        Recipe recipe = recipeRepository.findById(id);

        if(recipe == null) {
            throw new ResourceNotFoundException(Recipe.class, id);
        }

        return recipe;
    }

    @Override
    public List<Recipe> getRecipeDTOList() {
        return recipeRepository.findAll();
    }
}
