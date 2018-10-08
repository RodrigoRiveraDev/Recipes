package com.recipes.Controllers;

import java.util.List;
import com.recipes.DTO.RecipeDTO;
import com.recipes.Entities.Recipe;
import com.recipes.Services.IRecipeServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    private IRecipeServices recipeServices;

    @Autowired
    public RecipeController(IRecipeServices recipeServices) {
        this.recipeServices = recipeServices;
    }

    /**
     * This endpoint is to add a new Recipe
     * @param userId The user id that is registering the Recipe
     * @param newRecipe The Recipe object with the needed information (steps to elaborate it and ingredients list)
     * @return This will return a JSON with the created Recipe object or an exception
     */
    @PostMapping
    public Recipe registerRecipe(@RequestHeader(value="userId") int userId, @RequestBody Recipe newRecipe) {
        return recipeServices.save(newRecipe, userId);
    }

    /**
     * This endpoint is to update a registered Recipe
     * @param userId The user id that is updating the Recipe
     * @param id The recipe id
     * @param dataToUpdate The object with the desired information to update (steps to elaborate it and ingredients list)
     * @return This will return a JSON with the the modified Recipe object  or an exception
     */
    @PutMapping(value = "/{id}")
    public Recipe updateRecipe(@RequestHeader(value="userId") int userId, @PathVariable int id, @RequestBody RecipeDTO dataToUpdate) {
        return recipeServices.updateRecipeInfo(id, dataToUpdate, userId);
    }

    /**
     * This endpoint is to delete a registered Recipe
     * @param userId The user id that is deleting the Recipe
     * @param id The recipe id
     * @return This will return an empty JSON or an exception
     */
    @DeleteMapping(value = "/{id}")
    public void deleteRecipe(@RequestHeader(value="userId") int userId, @PathVariable int id) {
        recipeServices.deleteRecipe(userId, id);
    }

    /**
     * This endpoint is to retrieve a list wih all the registered Recipes
     * @return This will return a JSON with all the registered recipes list
     */
    @GetMapping
    public List<Recipe> recipeList() {
        return recipeServices.getRecipeDTOList();
    }

    /**
     * This endpoint is to retrieve a registered Recipe by its id
     * @param id The recipe id
     * @return This will return a JSON with the Recipe information or an exception
     */
    @GetMapping(value = "/{id}")
    public Recipe getRecipeById(@PathVariable int id) {
        return recipeServices.getRecipeById(id);
    }

}
