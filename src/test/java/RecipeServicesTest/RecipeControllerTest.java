package UserTests;

import com.recipes.Controllers.RecipeController;
import com.recipes.DTO.Ingredient;
import com.recipes.DTO.Recipe;
import com.recipes.Services.RecipeServices;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class RecipeControllerTest {

    @TestConfiguration
    static class RecipeServiceImplTestContextConfiguration {

        @Bean
        public RecipeServices recipeService() {
            return new RecipeServices();
        }

        @Bean
        public RecipeController recipeController() {
            return new RecipeController();
        }
    }

    @Autowired
    private RecipeServices recipeService;

    @Autowired
    private RecipeController recipeController;

    @Test
    public void addNewRecipe() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient());
        Recipe newRecipe = new Recipe(ingredients, "steps");
        int savedRecipes;
        recipeController.registerRecipe(newRecipe);
        savedRecipes = recipeController.recipeList().size();
        Assert.assertTrue(savedRecipes == 1);
    }

    @Test
    public void addNewRecipeThrowsIllegalArgumentException()  {
        HttpEntity response = recipeController.registerRecipe(new Recipe());
        Assert.assertTrue(response.getBody().equals("All the parameters must not be nulls or empties"));
    }
}