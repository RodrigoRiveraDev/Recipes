package com.recipes.Utilitaries;

import com.recipes.DTO.UserDTO;
import com.recipes.Entities.User;

import java.util.ArrayList;
import java.util.List;

public class Factory {
    public static User toUser(UserDTO userDTO) {
        return new User(userDTO.getFullName(), userDTO.getEmail(), userDTO.getPassword());
    }

    public static UserDTO toUserDTO(User user) {
        return new UserDTO(0, user.getFullName(), user.getEmail(), user.getPassword());
    }

    public static List<UserDTO> toUserDTOList(List<User> users) {
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user: users) {
            userDTOS.add(toUserDTO(user));
        }
        return userDTOS;
    }
}
