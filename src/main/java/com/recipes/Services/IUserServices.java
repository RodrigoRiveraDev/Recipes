package com.recipes.Services;

import com.recipes.DTO.UserDTO;
import com.recipes.Entities.User;

import java.util.List;

public interface IUserServices {

    public User save(User userDTO) throws Exception;

    public List<User> getUserList();

    public User findUserbyId(long id) throws Exception;

    public User updateUserInfo(int id, UserDTO dataToUpdate, int userId) throws Exception;
}
