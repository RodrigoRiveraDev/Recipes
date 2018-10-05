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

    @RequestMapping(method = RequestMethod.POST)
    public HttpEntity registerRecipe(@RequestBody Recipe newRecipe) {
        try {
            recipeServices.save(newRecipe);
            return new ResponseEntity<>(newRecipe, HttpStatus.CREATED);
        } catch (IllegalArgumentException illegalArgumentException) {
            return new ResponseEntity<>(illegalArgumentException.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public HttpEntity updateRecipe(@RequestHeader(value="userId") int userId, @PathVariable int id, @RequestBody RecipeDTO dataToUpdate) {
        try {
            RecipeDTO updatedRecipeDTO = recipeServices.updateRecipeInfo(id, dataToUpdate, userId);
            return new ResponseEntity<>(updatedRecipeDTO, HttpStatus.CREATED);
        } catch (IllegalArgumentException illegalArgumentException) {
            return new ResponseEntity<>(illegalArgumentException.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (ResourceNotFoundException resourceNotFoundException) {
            return new ResponseEntity<>(resourceNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (UnauthorizedException unauthorizedException) {
            return new ResponseEntity<>(unauthorizedException.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }

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

    @RequestMapping(method = RequestMethod.GET)
    public List<Recipe> recipeList() {
        return recipeServices.getRecipeDTOList();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getRecipeById(@PathVariable int id) {
        try {
            RecipeDTO foundedRecipeDTO = recipeServices.getRecipeById(id);
            return new ResponseEntity<>(foundedRecipeDTO, HttpStatus.OK);
        } catch (IllegalArgumentException illegalArgumentException) {
            return new ResponseEntity<>(illegalArgumentException.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (ResourceNotFoundException resourceNotFoundException) {
            return new ResponseEntity<>(resourceNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
