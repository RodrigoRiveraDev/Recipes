package UserTests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.hamcrest.Matchers.is;

import com.recipes.Application;
import com.recipes.DTO.UserDTO;
import com.recipes.Entities.User;
import com.recipes.Exceptions.ResourceNotFoundException;
import com.recipes.Exceptions.UnauthorizedException;
import com.recipes.Services.UserServices;
import org.hamcrest.Matchers;
import org.json.JSONObject;
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

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserControllerTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @MockBean
    private UserServices userServices;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void shouldReturnDefaultList() throws Exception {
        User user = new User("fullName", "password", "a@a.com");
        List<User> allUsers = Arrays.asList(user);

        BDDMockito.given(userServices.getUserList()).willReturn(allUsers);

        mockMvc.perform(get("/users")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].fullName", is(user.getFullName())));
    }

    @Test
    public void shouldAddNewUser() throws Exception {
        User user = new User("fullName", "password", "a@a.com");
        user.setId(1);

        JSONObject bodyAsJson = new JSONObject();
        bodyAsJson.put("fullName", user.getFullName());
        bodyAsJson.put("password", user.getPassword());
        bodyAsJson.put("email", user.getEmail());

        Mockito.when(userServices.save(Mockito.any(User.class))).thenReturn(user);

        mockMvc.perform(post("/users").contentType(APPLICATION_JSON)
                .content(bodyAsJson.toString()))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.fullName", is(user.getFullName())));
    }

    @Test
    public void shouldUpdateUser() throws Exception {
        User user = new User("fullName", "password", "a@a.com");
        user.setId(1);

        User updatedUser = new User("newFullName", "password", "a@a.com");

        JSONObject bodyAsJson = new JSONObject();
        bodyAsJson.put("fullName", updatedUser.getFullName());
        bodyAsJson.put("password", "");
        bodyAsJson.put("email", "");

        Mockito.when(userServices.updateUserInfo(Mockito.anyInt(), Mockito.any(UserDTO.class), Mockito.anyInt())).thenReturn(updatedUser);

        mockMvc.perform(put("/users/"+user.getId()).contentType(APPLICATION_JSON)
                .content(bodyAsJson.toString()).header("userId", user.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fullName", is(updatedUser.getFullName())))
                .andExpect(jsonPath("$.password", is(updatedUser.getPassword())))
                .andExpect(jsonPath("$.email", is(updatedUser.getEmail())));
    }

    @Test
    public void shouldNotUpdateUserUnauthorizedException() throws Exception {
        User user = new User("fullName", "password", "a@a.com");
        user.setId(1);

        User updatedUser = new User("newFullName", "password", "a@a.com");

        JSONObject bodyAsJson = new JSONObject();
        bodyAsJson.put("fullName", updatedUser.getFullName());
        bodyAsJson.put("password", "");
        bodyAsJson.put("email", "");

        Mockito.when(userServices.updateUserInfo(Mockito.anyInt(), Mockito.any(UserDTO.class), Mockito.anyInt()))
                .thenThrow(new UnauthorizedException());

        mockMvc.perform(put("/users/1").contentType(APPLICATION_JSON)
                .content(bodyAsJson.toString()).header("userId", 2))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void shouldGetUserById() throws Exception {
        User user = new User("fullName", "password", "a@a.com");
        user.setId(1);

        Mockito.when(userServices.findUserById(Mockito.anyLong())).thenReturn(user);

        mockMvc.perform(get("/users/"+user.getId()).contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fullName", is(user.getFullName())))
                .andExpect(jsonPath("$.password", is(user.getPassword())))
                .andExpect(jsonPath("$.email", is(user.getEmail())));
    }

    @Test
    public void shouldGetUserByIdNotFound() throws Exception {
        Mockito.when(userServices.findUserById(Mockito.anyLong()))
                .thenThrow(new ResourceNotFoundException(User.class, 1));

        mockMvc.perform(get("/users/1").contentType(APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
