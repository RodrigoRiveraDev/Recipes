package RecipeServicesTest;

import com.recipes.DTO.Ingredient;
import com.recipes.DTO.RecipeDTO;

import com.recipes.Exceptions.ResourceNotFoundException;
import com.recipes.Exceptions.UnauthorizedException;
import com.recipes.Services.RecipeServices;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class RecipeDTOServicesTest {
/*
    @Test
    public void addNewRecipe() {
        RecipeServices recipeServices = new RecipeServices(recipeRepository);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient());
        RecipeDTO newRecipeDTO = new RecipeDTO(ingredients, "steps");
        int savedRecipes;
        recipeServices.save(newRecipeDTO);
        savedRecipes = recipeServices.getRecipeDTOList().size();
        Assert.assertTrue(savedRecipes == 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNewRecipeThrowsIllegalArgumentException()  {
        RecipeServices recipeServices = new RecipeServices(recipeRepository);
        recipeServices.save(new RecipeDTO());
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateRecipeThrowsIllegalArgumentException()  {
        RecipeServices recipeServices = new RecipeServices(recipeRepository);
        recipeServices.updateRecipeInfo(-1, new RecipeDTO(), 4);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void updateRecipeThrowsResourceNotFoundException()  {
        RecipeServices recipeServices = new RecipeServices(recipeRepository);
        recipeServices.updateRecipeInfo(0, new RecipeDTO(), 4);
    }

    @Test(expected = UnauthorizedException.class)
    public void updateRecipeThrowsUnauthorizedException() {
        RecipeServices recipeServices = new RecipeServices(recipeRepository);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient());
        RecipeDTO newRecipeDTO = new RecipeDTO(ingredients, "steps");
        newRecipeDTO.setId(1);
        newRecipeDTO.setUserId(2);
        recipeServices.save(newRecipeDTO);
        RecipeDTO updateInfo = new RecipeDTO(new ArrayList<Ingredient>(), "new step");
        recipeServices.updateRecipeInfo(1, updateInfo, 5);
    }

    @Test
    public void updateRecipe() {
        RecipeServices recipeServices = new RecipeServices(recipeRepository);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient());
        RecipeDTO newRecipeDTO = new RecipeDTO(ingredients, "steps");
        newRecipeDTO.setId(1);
        newRecipeDTO.setUserId(2);
        recipeServices.save(newRecipeDTO);
        RecipeDTO updateInfo = new RecipeDTO(new ArrayList<Ingredient>(), "new step");
        RecipeDTO updatedRecipeDTO = recipeServices.updateRecipeInfo(1, updateInfo, 2);
        updateInfo.setId(1);
        updateInfo.setIngredients(ingredients);
        Assert.assertTrue(updatedRecipeDTO.equals(updateInfo));
    }

    @Test
    public void deleteRecipe() {
        RecipeServices recipeServices = new RecipeServices(recipeRepository);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient());
        RecipeDTO newRecipeDTO = new RecipeDTO(ingredients, "steps");
        newRecipeDTO.setId(1);
        newRecipeDTO.setUserId(2);
        recipeServices.save(newRecipeDTO);
        recipeServices.deleteRecipe(2, 1);
        int savedRecipes = recipeServices.getRecipeDTOList().size();
        Assert.assertTrue(savedRecipes == 0);
    }

    @Test(expected = UnauthorizedException.class)
    public void deleteRecipeThrowsUnauthorizedException() {
        RecipeServices recipeServices = new RecipeServices(recipeRepository);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient());
        RecipeDTO newRecipeDTO = new RecipeDTO(ingredients, "steps");
        newRecipeDTO.setId(1);
        newRecipeDTO.setUserId(2);
        recipeServices.save(newRecipeDTO);
        recipeServices.deleteRecipe(1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteRecipeThrowsIllegalArgumentException() {
        RecipeServices recipeServices = new RecipeServices(recipeRepository);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient());
        RecipeDTO newRecipeDTO = new RecipeDTO(ingredients, "steps");
        newRecipeDTO.setId(1);
        recipeServices.save(newRecipeDTO);
        recipeServices.deleteRecipe(1, -1);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void deleteRecipeThrowsResourceNotFoundException()  {
        RecipeServices recipeServices = new RecipeServices(recipeRepository);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient());
        RecipeDTO newRecipeDTO = new RecipeDTO(ingredients, "steps");
        newRecipeDTO.setId(1);
        recipeServices.save(newRecipeDTO);
        recipeServices.deleteRecipe(1, 5);
    }

    @Test
    public void findRecipeById() {
        RecipeServices recipeServices = new RecipeServices(recipeRepository);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient());
        RecipeDTO newRecipeDTO = new RecipeDTO(ingredients, "steps");
        newRecipeDTO.setId(1);
        newRecipeDTO.setUserId(2);
        recipeServices.save(newRecipeDTO);
        RecipeDTO foundedRecipeDTO = recipeServices.getRecipeById(1);
        Assert.assertTrue(foundedRecipeDTO.equals(newRecipeDTO));
    }

    @Test(expected = IllegalArgumentException.class)
    public void findRecipeByIdThrowsIllegalArgumentException() {
        RecipeServices recipeServices = new RecipeServices(recipeRepository);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient());
        RecipeDTO newRecipeDTO = new RecipeDTO(ingredients, "steps");
        newRecipeDTO.setId(1);
        recipeServices.save(newRecipeDTO);
        recipeServices.getRecipeById(-1);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void findRecipeByIdThrowsResourceNotFoundException()  {
        RecipeServices recipeServices = new RecipeServices(recipeRepository);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient());
        RecipeDTO newRecipeDTO = new RecipeDTO(ingredients, "steps");
        newRecipeDTO.setId(1);
        recipeServices.save(newRecipeDTO);
        recipeServices.getRecipeById(2);
    }*/
}
