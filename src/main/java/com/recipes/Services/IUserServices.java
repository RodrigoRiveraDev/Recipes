package com.recipes.Services;

import com.recipes.DTO.UserDTO;
import com.recipes.Entities.User;
import com.recipes.Exceptions.ResourceAlreadyExistsException;
import com.recipes.Exceptions.ResourceNotFoundException;
import com.recipes.Exceptions.UnauthorizedException;

import java.util.List;

public interface IUserServices {

    User save(User userDTO) throws ResourceAlreadyExistsException;

    List<User> getUserList();

    User findUserById(long id) throws ResourceNotFoundException;

    User updateUserInfo(int id, UserDTO dataToUpdate, int userId)
            throws UnauthorizedException, ResourceNotFoundException;
}
