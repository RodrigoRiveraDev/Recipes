package com.recipes.Controllers;

import java.util.List;
import com.recipes.DTO.UserDTO;
import com.recipes.Entities.User;
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

    /**
     * This endpoint is to add a new User
     * @param newUserDTO The User object with the needed information (full name, password, email)
     * @return This will return a JSON with the created User object or an exception
     */
    @PostMapping
    public HttpEntity registerUser(@RequestBody UserDTO newUserDTO) {
        try {
            userServices.save(newUserDTO);
            return new ResponseEntity<>(newUserDTO.toString(), HttpStatus.CREATED);
        } catch (IllegalArgumentException illegalArgumentException) {
            return new ResponseEntity<>(illegalArgumentException.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * This end point is to retrieve an User object by its id
     * @param id The user id
     * @return This will return a JSON with the User object or an exception
     */
    @GetMapping(value = "/{id}")
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

    /**
     * This endpoint is to update a registered User
     * @param userId The user id that is updating the user
     * @param id The user id to update the information
     * @param dataToUpdate The object with the desired information to update (full name, password, email)
     * @return This will return a JSON with the modified User object or an exception
     */
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

    /**
     * This endpoint is to retrieve a list with all the registered users
     * @return This will return a JSON with all the registered users list
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<User> userList() {
        return userServices.getUserList();
    }
}
