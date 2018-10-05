package com.recipes.Services;

import com.recipes.DTO.RecipeDTO;
import com.recipes.Entities.Recipe;
import com.recipes.Exceptions.ResourceNotFoundException;
import com.recipes.Exceptions.UnauthorizedException;
import com.recipes.Repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeServices implements IRecipeServices {

    private List<RecipeDTO> recipeDTOList = new ArrayList<>();
    private RecipeRepository recipeRepository;

    @Autowired
    public RecipeServices(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }


    @Override
    public void save(Recipe recipe) {
        /*if(!recipe.hasAllParameters()) {
            throw new IllegalArgumentException("All the parameters must not be nulls or empties");
        }
        recipeDTOList.add(recipe);*/
        recipeRepository.save(recipe);
    }

    @Override
    public RecipeDTO updateRecipeInfo(int id, RecipeDTO dataToUpdate, int userId) {
        RecipeDTO foundedRecipeDTO = null;
        int index = recipeDTOList.size();
        if(id < 0) {
            throw new IllegalArgumentException("Negative id is not valid");
        }

        while(foundedRecipeDTO == null && --index >= 0) {
            foundedRecipeDTO = (recipeDTOList.get(index).hasId(id)) ? recipeDTOList.get(index) : null;
        }

        if(foundedRecipeDTO == null) {
            throw new ResourceNotFoundException(RecipeDTO.class, id);
        }

        if(!foundedRecipeDTO.isOwner(userId)) {
            throw new UnauthorizedException();
        }

        foundedRecipeDTO.updateInfo(dataToUpdate);
        return foundedRecipeDTO;
    }

    @Override
    public void deleteRecipe(int userId, int recipeId) {
        int foundedRecipeIndex = -1;
        int index = recipeDTOList.size();
        if(recipeId < 0) {
            throw new IllegalArgumentException("Negative id is not valid");
        }

        while(foundedRecipeIndex == -1 && --index >= 0) {
            foundedRecipeIndex = (recipeDTOList.get(index).hasId(recipeId)) ? index : -1;
        }

        if(foundedRecipeIndex == -1) {
            throw new ResourceNotFoundException(RecipeDTO.class, recipeId);
        }

        RecipeDTO foundedRecipeDTO = recipeDTOList.get(foundedRecipeIndex);

        if(!foundedRecipeDTO.isOwner(userId)) {
            throw new UnauthorizedException();
        }

        recipeDTOList.remove(foundedRecipeDTO);
    }

    @Override
    public RecipeDTO getRecipeById(int id) {
        RecipeDTO foundedRecipeDTO = null;
        int index = recipeDTOList.size();
        if(id < 0) {
            throw new IllegalArgumentException("Negative id is not valid");
        }

        while(foundedRecipeDTO == null && --index >= 0) {
            foundedRecipeDTO = (recipeDTOList.get(index).hasId(id)) ? recipeDTOList.get(index) : null;
        }

        if(foundedRecipeDTO == null) {
            throw new ResourceNotFoundException(RecipeDTO.class, id);
        }

        return foundedRecipeDTO;
    }

    @Override
    public List<Recipe> getRecipeDTOList() {
        return recipeRepository.findAll();//return recipeDTOList;
    }
}
