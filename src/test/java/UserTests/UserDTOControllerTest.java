package UserTests;

import com.recipes.Controllers.UserController;
import com.recipes.DTO.UserDTO;
import com.recipes.Services.UserServices;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class UserDTOControllerTest {
    /*
    @TestConfiguration
    static class UsersServiceImplTestContextConfiguration {

        @Bean
        public UserServices usersService() {
            return new UserServices();
        }

        @Bean
        public UserController userController() {
            return new UserController();
        }
    }

    @Autowired
    private UserServices usersService;

    @Autowired
    private UserController userController;

    @Test
    public void addNewUser() {
        UserDTO newUserDTO = new UserDTO(1, "fullName", "email", "password");
        int originalSavedUsers = userController.userList().size();
        userController.registerUser(newUserDTO);
        int newSavedUsers = userController.userList().size();
        Assert.assertTrue(newSavedUsers == originalSavedUsers + 1);
    }

    @Test
    public void addNewUserThrowsException()  {
        UserDTO newUserDTO = new UserDTO();
        HttpEntity response = userController.registerUser(newUserDTO);
        Assert.assertTrue(response.getBody().equals("All the parameters must not be nulls or empties"));
    }

    @Test
    public void findUserbyId()  {
        UserDTO newUserDTO = new UserDTO(1, "fullName", "email", "password");
        userController.registerUser(newUserDTO);
        HttpEntity<UserDTO> response = userController.getUserById(1);
        UserDTO foundedUserDTO = response.getBody();
        Assert.assertTrue(foundedUserDTO.toString().equals(newUserDTO.toString()));
    }

    @Test
    public void findUserbyIdThrowsIllegalArgumentException()  {
        HttpEntity response = userController.getUserById(-1);
        Assert.assertTrue(response.getBody().equals("Negative id is not valid"));
    }

    @Test
    public void findUserbyIdThrowsResourceNotFoundException()  {
        HttpEntity response = userController.getUserById(0);
        Assert.assertTrue(response.getBody().equals("The UserDTO with id " + 0 + " was not found"));
    }

    @Test
    public void updateUser()  {
        UserDTO newUserDTO = new UserDTO(1, "fullName", "email", "password");
        userController.registerUser(newUserDTO);
        UserDTO updateInfo = new UserDTO(1, "NewfullName", "Newemail", "password");
        HttpEntity<UserDTO> response = userController.updateUser(1,1, updateInfo);
        UserDTO updatedUserDTO = response.getBody();
        Assert.assertTrue(updatedUserDTO.toString().equals(updateInfo.toString()));
    }

    @Test
    public void updateUserThrowsIllegalArgumentException()  {
        HttpEntity response = userController.updateUser(1, -1, new UserDTO());
        Assert.assertTrue(response.getBody().equals("Negative id is not valid"));
    }

    @Test
    public void updateUserThrowsResourceNotFoundException()  {
        HttpEntity response = userController.updateUser(1, 0, new UserDTO());
        Assert.assertTrue(response.getBody().equals("The UserDTO with id " + 0 + " was not found"));
    }

    @Test
    public void updateUserThrowsUnauthorizedException() {
        UserDTO newUserDTO = new UserDTO(1, "fullName", "email", "password");
        userController.registerUser(newUserDTO);
        UserDTO updateInfo = new UserDTO(1, "NewfullName", "Newemail", "password");
        HttpEntity response = userController.updateUser(3,1, updateInfo);
        Assert.assertTrue(response.getBody().equals("You don't have the permission to execute this action"));
    }*/
}
