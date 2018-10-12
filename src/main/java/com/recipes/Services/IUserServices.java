package com.recipes.Services;

import com.recipes.DTO.UserDTO;
import com.recipes.Entities.User;
import com.recipes.Exceptions.ResourceAlreadyExistsException;
import com.recipes.Exceptions.ResourceNotFoundException;
import com.recipes.Exceptions.UnauthorizedException;

import java.util.List;

public interface IUserServices {

    /**
     * @param user The User information to be stored
     * @return It will return the user that has been stored
     * @throws ResourceAlreadyExistsException In case that there is a user with the same provided data stored
     */
    User save(User user) throws ResourceAlreadyExistsException;

    /**
     * @return It will return a list with all the registered users
     */
    List<User> getUserList();

    /**
     * @param id The user id to search for
     * @return It will return the User with the provided id
     * @throws ResourceNotFoundException In case that there is not a registered user with the provided id
     */
    User findUserById(long id) throws ResourceNotFoundException;

    /**
     * @param userIdToUpdate The user id to update
     * @param dataToUpdate The data to modify in the User entity
     * @param userId The user that request the update
     * @return It will return the updated user
     * @throws UnauthorizedException In case that user that request the update is not the user to be updated
     * @throws ResourceNotFoundException In case that there is not a registered user with the provided id
     */
    User updateUserInfo(long userIdToUpdate, UserDTO dataToUpdate, long userId)
            throws UnauthorizedException, ResourceNotFoundException;
}
