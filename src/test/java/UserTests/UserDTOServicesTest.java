package UserTests;

import com.recipes.DTO.UserDTO;

import com.recipes.Exceptions.ResourceNotFoundException;
import com.recipes.Exceptions.UnauthorizedException;
import com.recipes.Services.UserServices;
import org.junit.Assert;
import org.junit.Test;


public class UserDTOServicesTest {
    /*
    @Test
    public void addNewUser() {
        UserServices userServices = new UserServices();
        UserDTO newUserDTO = new UserDTO(1, "fullName", "email", "password");
        userServices.save(newUserDTO);
        int savedUsers = userServices.getUserList().size();
        Assert.assertTrue(savedUsers == 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNewUserThrowsException()  {
        UserServices userServices = new UserServices();
        UserDTO newUserDTO = new UserDTO();
        userServices.save(newUserDTO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findUserbyIdThrowsIllegalArgumentException()  {
        UserServices userServices = new UserServices();
        userServices.findUserbyId(-1);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void findUserbyIdThrowsResourceNotFoundException()  {
        UserServices userServices = new UserServices();
        userServices.findUserbyId(0);
    }

    @Test
    public void findUserById() {
        UserServices userServices = new UserServices();
        UserDTO newUserDTO = new UserDTO(1, "fullName", "email", "password");
        userServices.save(newUserDTO);
        UserDTO foundedUserDTO = userServices.findUserbyId(1);
        Assert.assertTrue(foundedUserDTO.toString().equals(newUserDTO.toString()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateUserThrowsIllegalArgumentException()  {
        UserServices userServices = new UserServices();
        userServices.updateUserInfo(-1, new UserDTO(), 1);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void updateUserThrowsResourceNotFoundException()  {
        UserServices userServices = new UserServices();
        userServices.updateUserInfo(0, new UserDTO(), 1);
    }

    @Test(expected = UnauthorizedException.class)
    public void updateUserThrowsUnauthorizedException() {
        UserServices userServices = new UserServices();
        UserDTO newUserDTO = new UserDTO(1, "fullName", "email", "password");
        userServices.save(newUserDTO);
        UserDTO updateInfo = new UserDTO(1, "NewfullName", "Newemail", "password");
        UserDTO foundedUserDTO = userServices.updateUserInfo(1, updateInfo,3);
        Assert.assertTrue(foundedUserDTO.equals(updateInfo));
    }

    @Test
    public void updateUser() {
        UserServices userServices = new UserServices();
        UserDTO newUserDTO = new UserDTO(1, "fullName", "email", "password");
        userServices.save(newUserDTO);
        UserDTO updateInfo = new UserDTO(1, "NewfullName", "Newemail", "password");
        UserDTO foundedUserDTO = userServices.updateUserInfo(1, updateInfo,1);
        Assert.assertTrue(foundedUserDTO.toString().equals(updateInfo.toString()));
    }*/
}
