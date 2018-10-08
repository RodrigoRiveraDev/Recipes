package com.recipes.Services;

import com.recipes.DTO.RecipeDTO;
import com.recipes.Entities.Recipe;
import com.recipes.Entities.User;
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
    public void save(Recipe recipe, long userId) {
        User user = userServices.findUserbyId(userId);
        if(user != null) {
            user.setId(userId);
            recipe.setUserId(userId);
        }
        recipeRepository.save(recipe);
    }

    @Override
    public Recipe updateRecipeInfo(int recipeId, RecipeDTO dataToUpdate, int userId) {
        Recipe recipe = recipeRepository.findById(recipeId);
        if(recipe.getUserId() == userId) {
            if(!dataToUpdate.getHowElaborate().isEmpty()) {
                recipe.setHowElaborate(dataToUpdate.getHowElaborate());
            }
            if(dataToUpdate.getIngredients().size() > 0) {
                recipe.setIngredients(Factory.toIngredientsList(dataToUpdate.getIngredients()));
            }
            recipeRepository.save(recipe);
        }
        return recipe;
    }

    @Override
    public void deleteRecipe(int userId, int recipeId) {
        Recipe recipe = recipeRepository.findById(userId);
        if(recipe != null && recipe.getUserId() == recipeId) {
            recipeRepository.delete(recipe);
        }
    }

    @Override
    public Recipe getRecipeById(int id) {
        return recipeRepository.findById(id);
    }

    @Override
    public List<Recipe> getRecipeDTOList() {
        return recipeRepository.findAll();
    }
}
