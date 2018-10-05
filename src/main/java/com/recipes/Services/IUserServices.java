package com.recipes.Services;

import com.recipes.DTO.UserDTO;
import com.recipes.Entities.User;

import java.util.List;

public interface IUserServices {

    public void save(UserDTO userDTO);

    public List<User> getUserList();

    public UserDTO findUserbyId(long id);

    public UserDTO updateUserInfo(int id, UserDTO dataToUpdate, int userId);
}
