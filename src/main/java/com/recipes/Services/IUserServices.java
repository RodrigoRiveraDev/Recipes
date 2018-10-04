package com.recipes.Services;

import com.recipes.DTO.User;

import java.util.List;

public interface IUserServices {

    public void save(User user);

    public List<User> getUserList();

    public User findUserbyId(int id);

    public User updateUserInfo(int id, User dataToUpdate, int userId);
}
