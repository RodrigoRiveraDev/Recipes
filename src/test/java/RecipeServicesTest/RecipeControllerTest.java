package RecipeServicesTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.hamcrest.Matchers.is;

import com.recipes.Application;
import com.recipes.DTO.RecipeDTO;
import com.recipes.Entities.Ingredient;
import com.recipes.Entities.Recipe;
import com.recipes.Entities.User;
import com.recipes.Exceptions.ResourceNotFoundException;
import com.recipes.Exceptions.UnauthorizedException;
import com.recipes.Services.RecipeServices;
import com.recipes.Services.UserServices;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RecipeControllerTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @MockBean
    private RecipeServices recipeServices;
    @MockBean
    private UserServices userServices;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void shouldReturnDefaultList() throws Exception {
        Recipe recipe = new Recipe("howElaborate", new ArrayList<>());
        List<Recipe> allRecipes = Arrays.asList(recipe);

        BDDMockito.given(recipeServices.getRecipeDTOList()).willReturn(allRecipes);

        mockMvc.perform(get("/recipes")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].howElaborate", is(recipe.getHowElaborate())));
    }

    @Test
    public void shouldAddNewRecipe() throws Exception {
        Ingredient ingredient = new Ingredient();
        ingredient.setName("sugar");
        ingredient.setUnit("gr");
        ingredient.setQuantity(15);
        Recipe recipe = new Recipe("howElaborate", Arrays.asList(ingredient));

        Mockito.when(recipeServices.save(Mockito.any(Recipe.class), Mockito.anyLong())).thenReturn(recipe);

        String jsonBody = com.recipes.Utilitaries.Factory.recipeDTO(recipe).toString();

        mockMvc.perform(post("/recipes").contentType(APPLICATION_JSON)
                .content(jsonBody)
                .header("userId", 1))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.howElaborate", is(recipe.getHowElaborate())));
    }

    @Test
    public void shouldNotAddNewRecipeUnauthorizedException() throws Exception {
        Ingredient ingredient = new Ingredient();
        ingredient.setName("sugar");
        ingredient.setUnit("gr");
        ingredient.setQuantity(15);
        Recipe recipe = new Recipe("howElaborate", Arrays.asList(ingredient));

        User user = new User("fullName", "password", "a@a.com");
        user.setId(1);

        Mockito.when(userServices.findUserById(Mockito.anyLong())).thenReturn(user);
        Mockito.when(recipeServices.save(Mockito.any(Recipe.class), Mockito.anyLong()))
                .thenThrow(new UnauthorizedException());

        String jsonBody = com.recipes.Utilitaries.Factory.recipeDTO(recipe).toString();

        mockMvc.perform(post("/recipes").contentType(APPLICATION_JSON)
                .content(jsonBody)
                .header("userId", 2))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void shouldUpdateRecipe() throws Exception {
        Ingredient ingredient = new Ingredient();
        ingredient.setName("sugar");
        ingredient.setUnit("gr");
        ingredient.setQuantity(15);
        Recipe recipe = new Recipe("howElaborate", Arrays.asList(ingredient));

        Mockito.when(recipeServices.updateRecipeInfo(Mockito.anyLong(), Mockito.any(RecipeDTO.class), Mockito.anyLong()))
                .thenReturn(recipe);

        String jsonBody = com.recipes.Utilitaries.Factory.recipeDTO(recipe).toString();

        mockMvc.perform(put("/recipes/{id}", 2).contentType(APPLICATION_JSON)
                .content(jsonBody)
                .header("userId", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.howElaborate", is(recipe.getHowElaborate())));
    }

    @Test
    public void shouldNotUpdateRecipeUnauthorized() throws Exception {
        Ingredient ingredient = new Ingredient();
        ingredient.setName("sugar");
        ingredient.setUnit("gr");
        ingredient.setQuantity(15);
        Recipe recipe = new Recipe("howElaborate", Arrays.asList(ingredient));

        Mockito.when(recipeServices.updateRecipeInfo(Mockito.anyLong(), Mockito.any(RecipeDTO.class), Mockito.anyLong()))
                .thenThrow(new UnauthorizedException());

        String jsonBody = com.recipes.Utilitaries.Factory.recipeDTO(recipe).toString();

        mockMvc.perform(put("/recipes/{id}", 2).contentType(APPLICATION_JSON)
                .content(jsonBody)
                .header("userId", 20))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void shouldNotUpdateRecipeNotFound() throws Exception {
        Ingredient ingredient = new Ingredient();
        ingredient.setName("sugar");
        ingredient.setUnit("gr");
        ingredient.setQuantity(15);
        Recipe recipe = new Recipe("howElaborate", Arrays.asList(ingredient));

        Mockito.when(recipeServices.updateRecipeInfo(Mockito.anyLong(), Mockito.any(RecipeDTO.class), Mockito.anyLong()))
                .thenThrow(new ResourceNotFoundException(Recipe.class, 9));

        String jsonBody = com.recipes.Utilitaries.Factory.recipeDTO(recipe).toString();

        mockMvc.perform(put("/recipes/{id}", 20).contentType(APPLICATION_JSON)
                .content(jsonBody)
                .header("userId", 9))
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldFindById() throws Exception {
        Ingredient ingredient = new Ingredient();
        ingredient.setName("sugar");
        ingredient.setUnit("gr");
        ingredient.setQuantity(15);
        Recipe recipe = new Recipe("howElaborate", Arrays.asList(ingredient));

        Mockito.when(recipeServices.getRecipeById(Mockito.anyLong())).thenReturn(recipe);

        String jsonBody = com.recipes.Utilitaries.Factory.recipeDTO(recipe).toString();

        mockMvc.perform(get("/recipes/{id}", 1).contentType(APPLICATION_JSON)
                .header("userId", 20))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.howElaborate", is(recipe.getHowElaborate())));
    }

    @Test
    public void shouldFindByIdNotFound() throws Exception {
        Ingredient ingredient = new Ingredient();
        ingredient.setName("sugar");
        ingredient.setUnit("gr");
        ingredient.setQuantity(15);
        Recipe recipe = new Recipe("howElaborate", Arrays.asList(ingredient));

        Mockito.when(recipeServices.getRecipeById(Mockito.anyLong()))
                .thenThrow(new ResourceNotFoundException(Recipe.class, 9));

        String jsonBody = com.recipes.Utilitaries.Factory.recipeDTO(recipe).toString();

        mockMvc.perform(get("/recipes/{id}", 1).contentType(APPLICATION_JSON)
                .header("userId", 20))
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldDelete() throws Exception {
        Mockito.doNothing().when(recipeServices).deleteRecipe(Mockito.anyLong(), Mockito.anyLong());

        mockMvc.perform(delete("/recipes/{id}", 1).contentType(APPLICATION_JSON)
                .header("userId", 1))
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldNotDeleteUnauthorized() throws Exception {
        Mockito.doThrow(new UnauthorizedException()).when(recipeServices)
                .deleteRecipe(Mockito.anyLong(), Mockito.anyLong());

        mockMvc.perform(delete("/recipes/{id}", 1).contentType(APPLICATION_JSON)
                .header("userId", 20))
                .andExpect(status().isUnauthorized());
    }
}
