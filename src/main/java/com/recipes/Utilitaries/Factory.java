package com.recipes.Utilitaries;

import com.recipes.Entities.Ingredient;
import com.recipes.Entities.Recipe;
import recipes.sharedDomain.DTO.IngredientDTO;
import recipes.sharedDomain.DTO.RecipeDTO;

import java.util.ArrayList;
import java.util.List;

public class Factory {

    /**
     * @param recipe Recipe entity to transform to RecipeDTO
     * @return It will return the RecipeDTO from the provided Recipe
     */
    public static RecipeDTO recipeDTO(Recipe recipe) {
        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setHowElaborate(recipe.getHowElaborate());
        recipeDTO.setIngredients(toIngredientDTOList(recipe.getIngredients()));
        return recipeDTO;
    }

    /**
     * @param ingredients A list with Ingredient objects
     * @return A list with IngredientDTO objects
     */
    public static List<IngredientDTO> toIngredientDTOList(List<Ingredient> ingredients) {
        List<IngredientDTO> ingredientDTOs = new ArrayList<>();
        for(Ingredient ingredientDTO: ingredients) {
            ingredientDTOs.add(new IngredientDTO(ingredientDTO.getName(),
                    ingredientDTO.getQuantity(), ingredientDTO.getUnit()));
        }
        return ingredientDTOs;
    }

    /**
     * @param ingredientDTOS A list with IngredientDTO objects
     * @return A list with Ingredient objects
     */
    public static List<Ingredient> toIngredientList(List<IngredientDTO> ingredientDTOS) {
        List<Ingredient> ingredients = new ArrayList<>();
        for(IngredientDTO ingredientDTO: ingredientDTOS) {
            ingredients.add(new Ingredient(ingredientDTO.getName(),
                    ingredientDTO.getQuantity(), ingredientDTO.getUnit()));
        }
        return ingredients;
    }
}
