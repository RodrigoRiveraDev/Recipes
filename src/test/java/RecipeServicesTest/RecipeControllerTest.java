package RecipeServicesTest;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class RecipeControllerTest {
    /*
    @TestConfiguration
    static class RecipeServiceImplTestContextConfiguration {

        @Bean
        public RecipeServices recipeService() {
            return new RecipeServices();
        }

        @Bean
        public RecipeController recipeController() {
            return new RecipeController(recipeService);
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
        RecipeDTO newRecipe = new RecipeDTO(ingredients, "steps");
        int savedRecipes;
        HttpEntity re = recipeController.registerRecipe(newRecipe);
        RecipeDTO postReturn = (RecipeDTO)re.getBody();
        savedRecipes = recipeController.recipeList().size();
        Assert.assertTrue(postReturn.equals(newRecipe));
    }

    @Test
    public void addNewRecipeThrowsIllegalArgumentException()  {
        HttpEntity response = recipeController.registerRecipe(new RecipeDTO());
        Assert.assertTrue(response.getBody().equals("All the parameters must not be nulls or empties"));
    }

    @Test
    public void updateRecipeThrowsIllegalArgumentException()  {
        HttpEntity response = recipeController.updateRecipe(4, -1, new RecipeDTO());
        Assert.assertTrue(response.getBody().equals("Negative id is not valid"));
    }

    @Test
    public void updateRecipeThrowsResourceNotFoundException()  {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient());
        RecipeDTO newRecipe = new RecipeDTO(ingredients, "steps");
        HttpEntity response = recipeController.updateRecipe(4,9, newRecipe);
        Assert.assertTrue(response.getBody().equals("The RecipeDTO with id " + 9 + " was not found"));
    }

    @Test
    public void updateRecipeThrowsUnauthorizedException() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient());
        RecipeDTO newRecipe = new RecipeDTO(ingredients, "steps");
        newRecipe.setId(1);
        newRecipe.setUserId(2);
        recipeController.registerRecipe(newRecipe);
        RecipeDTO updateInfo = new RecipeDTO(new ArrayList<Ingredient>(), "new step");
        HttpEntity response = recipeController.updateRecipe(4, 1, updateInfo);
        Assert.assertTrue(response.getBody().equals("You don't have the permission to execute this action"));
    }

    @Test
    public void updateRecipe() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient());
        RecipeDTO newRecipe = new RecipeDTO(ingredients, "steps");
        newRecipe.setId(1);
        newRecipe.setUserId(4);
        recipeController.registerRecipe(newRecipe);
        RecipeDTO updateInfo = new RecipeDTO(new ArrayList<Ingredient>(), "new step");
        RecipeDTO updatedRecipe = (RecipeDTO) recipeController.updateRecipe(4,1, updateInfo).getBody();
        updateInfo.setId(1);
        updateInfo.setIngredients(ingredients);
        Assert.assertTrue(updatedRecipe.equals(updateInfo));
    }

    @Test
    public void deleteRecipe() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient());
        RecipeDTO newRecipe = new RecipeDTO(ingredients, "steps");
        newRecipe.setId(1);
        newRecipe.setUserId(2);
        recipeController.registerRecipe(newRecipe);
        int savedRecipes = recipeController.recipeList().size();
        recipeController.deleteRecipe(2, 1);
        int postDeletionSavedRecipes = recipeController.recipeList().size();
        Assert.assertTrue(savedRecipes == postDeletionSavedRecipes+1);
    }

    @Test
    public void deleteRecipeThrowsUnauthorizedException() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient());
        RecipeDTO newRecipe = new RecipeDTO(ingredients, "steps");
        newRecipe.setId(1);
        newRecipe.setUserId(2);
        recipeController.registerRecipe(newRecipe);
        HttpEntity response = recipeController.deleteRecipe(1, 1);
        Assert.assertTrue(response.getBody().equals("You don't have the permission to execute this action"));
    }

    @Test
    public void deleteRecipeThrowsIllegalArgumentException() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient());
        RecipeDTO newRecipe = new RecipeDTO(ingredients, "steps");
        newRecipe.setId(1);
        recipeController.registerRecipe(newRecipe);
        HttpEntity response = recipeController.deleteRecipe(1, -1);
        Assert.assertTrue(response.getBody().equals("Negative id is not valid"));
    }

    @Test
    public void deleteRecipeThrowsResourceNotFoundException()  {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient());
        RecipeDTO newRecipe = new RecipeDTO(ingredients, "steps");
        newRecipe.setId(1);
        recipeController.registerRecipe(newRecipe);
        HttpEntity response = recipeController.deleteRecipe(1, 5);
        Assert.assertTrue(response.getBody().equals("The RecipeDTO with id " + 5 + " was not found"));
    }

    @Test
    public void findRecipeById() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient());
        RecipeDTO newRecipe = new RecipeDTO(ingredients, "steps");
        newRecipe.setId(1);
        newRecipe.setUserId(2);
        recipeController.registerRecipe(newRecipe);
        HttpEntity response = recipeController.getRecipeById(1);
        RecipeDTO foundedRecipe = (RecipeDTO) response.getBody();
        Assert.assertTrue(foundedRecipe.equals(newRecipe));
    }

    @Test
    public void findRecipeByIdThrowsIllegalArgumentException() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient());
        RecipeDTO newRecipe = new RecipeDTO(ingredients, "steps");
        newRecipe.setId(1);
        recipeController.registerRecipe(newRecipe);
        HttpEntity response = recipeController.getRecipeById(-1);
        Assert.assertTrue(response.getBody().equals("Negative id is not valid"));
    }

    @Test
    public void findRecipeByIdThrowsResourceNotFoundException()  {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient());
        RecipeDTO newRecipe = new RecipeDTO(ingredients, "steps");
        newRecipe.setId(1);
        recipeController.registerRecipe(newRecipe);
        HttpEntity response = recipeController.getRecipeById(9);
        Assert.assertTrue(response.getBody().equals("The RecipeDTO with id " + 9 + " was not found"));
    }*/
}
