package com.recipes.Utilitaries;

import com.recipes.DTO.UserDTO;
import com.recipes.Entities.Recipe;
import com.recipes.Entities.User;

import java.util.ArrayList;
import java.util.List;

public class Factory {
    public static User toUser(UserDTO userDTO) {
        return new User(userDTO.getFullName(), userDTO.getPassword(), userDTO.getEmail());
    }

    public static UserDTO toUserDTO(User user) {
        return new UserDTO(user.getId(), user.getFullName(), user.getEmail(), user.getPassword());
    }

    public static List<UserDTO> toUserDTOList(List<User> users) {
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user: users) {
            userDTOS.add(toUserDTO(user));
        }
        return userDTOS;
    }

}
