package com.recipes.Controllers;

import java.util.List;
import com.recipes.DTO.RecipeDTO;
import com.recipes.Entities.Recipe;
import com.recipes.Exceptions.ResourceNotFoundException;
import com.recipes.Exceptions.UnauthorizedException;
import com.recipes.Services.IRecipeServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @RequestMapping(method = RequestMethod.POST)
    public HttpEntity registerRecipe(@RequestHeader(value="userId") int userId, @RequestBody Recipe newRecipe) {
        try {
            recipeServices.save(newRecipe, userId);
            return new ResponseEntity<>(newRecipe, HttpStatus.CREATED);
        } catch (IllegalArgumentException illegalArgumentException) {
            return new ResponseEntity<>(illegalArgumentException.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    /**
     * This endpoint is to update a registered Recipe
     * @param userId The user id that is updating the Recipe
     * @param id The recipe id
     * @param dataToUpdate The information with the desired information to update (steps to elaborate it and ingredients list)
     * @return This will return a JSON with the the modified Recipe object  or an exception
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public HttpEntity updateRecipe(@RequestHeader(value="userId") int userId, @PathVariable int id, @RequestBody RecipeDTO dataToUpdate) {
        try {
            Recipe updatedRecipeDTO = recipeServices.updateRecipeInfo(id, dataToUpdate, userId);
            return new ResponseEntity<>(updatedRecipeDTO, HttpStatus.CREATED);
        } catch (IllegalArgumentException illegalArgumentException) {
            return new ResponseEntity<>(illegalArgumentException.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (ResourceNotFoundException resourceNotFoundException) {
            return new ResponseEntity<>(resourceNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (UnauthorizedException unauthorizedException) {
            return new ResponseEntity<>(unauthorizedException.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * This endpoint is to delete a registered Recipe
     * @param userId The user id that is deleting the Recipe
     * @param id The recipe id
     * @return This will return an empty JSON or an exception
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public HttpEntity deleteRecipe(@RequestHeader(value="userId") int userId, @PathVariable int id) {
        try {
            recipeServices.deleteRecipe(userId, id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException illegalArgumentException) {
            return new ResponseEntity<>(illegalArgumentException.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (ResourceNotFoundException resourceNotFoundException) {
            return new ResponseEntity<>(resourceNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (UnauthorizedException unauthorizedException) {
            return new ResponseEntity<>(unauthorizedException.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * This endpoint is to retrieve a list wih all the registered Recipes
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Recipe> recipeList() {
        return recipeServices.getRecipeDTOList();
    }

    /**
     * This endpoint is to retrieve a registered Recipe by its id
     * @param id The recipe id
     * @return This will return a JSON with the Recipe information or an exception
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getRecipeById(@PathVariable int id) {
        try {
            Recipe foundedRecipeDTO = recipeServices.getRecipeById(id);
            return new ResponseEntity<>(foundedRecipeDTO, HttpStatus.OK);
        } catch (IllegalArgumentException illegalArgumentException) {
            return new ResponseEntity<>(illegalArgumentException.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (ResourceNotFoundException resourceNotFoundException) {
            return new ResponseEntity<>(resourceNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
