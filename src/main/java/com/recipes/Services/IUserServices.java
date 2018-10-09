package com.recipes.Services;

import com.recipes.DTO.UserDTO;
import com.recipes.Entities.User;

import java.util.List;

public interface IUserServices {

    User save(User userDTO) throws Exception;

    List<User> getUserList();

    User findUserById(long id) throws Exception;

    User updateUserInfo(int id, UserDTO dataToUpdate, int userId) throws Exception;
}
