package com.recipes.Services;

import com.recipes.DTO.UserDTO;

import java.util.List;

public interface IUserServices {

    public void save(UserDTO userDTO);

    public List<UserDTO> getUserList();

    public UserDTO findUserbyId(int id);

    public UserDTO updateUserInfo(int id, UserDTO dataToUpdate, int userId);
}
