package com.recipes.Controllers;

import java.util.List;
import com.recipes.DTO.UserDTO;
import com.recipes.Exceptions.ResourceNotFoundException;
import com.recipes.Exceptions.UnauthorizedException;
import com.recipes.Services.IUserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserServices userServices;

    @RequestMapping(method = RequestMethod.POST)
    public HttpEntity registerUser(@RequestBody UserDTO newUserDTO) {
        try {
            userServices.save(newUserDTO);
            return new ResponseEntity<>(newUserDTO.toString(), HttpStatus.CREATED);
        } catch (IllegalArgumentException illegalArgumentException) {
            return new ResponseEntity<>(illegalArgumentException.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public HttpEntity getUserById(@PathVariable int id) {
        try {
            UserDTO foundedUserDTO = userServices.findUserbyId(id);
            return new ResponseEntity<>(foundedUserDTO, HttpStatus.OK);
        } catch (IllegalArgumentException ilegalArugmentException) {
            return new ResponseEntity<>(ilegalArugmentException.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (ResourceNotFoundException resourceNotFoundException) {
            return new ResponseEntity<>(resourceNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public HttpEntity updateUser(@RequestHeader(value="userId") int userId, @PathVariable int id, @RequestBody UserDTO dataToUpdate) {
        try {
            UserDTO foundedUserDTO = userServices.updateUserInfo(id, dataToUpdate, userId);
            return new ResponseEntity<>(foundedUserDTO, HttpStatus.CREATED);
        } catch (IllegalArgumentException ilegalArugmentException) {
            return new ResponseEntity<>(ilegalArugmentException.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (ResourceNotFoundException resourceNotFoundException) {
            return new ResponseEntity<>(resourceNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
        } catch (UnauthorizedException unauthorizedException) {
            return new ResponseEntity<>(unauthorizedException.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<UserDTO> userList() {
        return userServices.getUserList();
    }
}
