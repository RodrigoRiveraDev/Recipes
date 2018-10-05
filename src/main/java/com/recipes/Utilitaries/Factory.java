package com.recipes.Utilitaries;

import com.recipes.DTO.Ingredient;
import com.recipes.DTO.UserDTO;
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

    public static List<com.recipes.Entities.Ingredient> toIngredientsList(List<Ingredient> ingredientsDTO) {
        List<com.recipes.Entities.Ingredient> ingredients = new ArrayList<>();
        for (Ingredient ingredient: ingredientsDTO) {
            ingredients.add(toIngredient(ingredient));
        }
        return ingredients;
    }

    private static com.recipes.Entities.Ingredient toIngredient(Ingredient ingredientDTO) {
        com.recipes.Entities.Ingredient ingredient = new com.recipes.Entities.Ingredient();
        ingredient.setName(ingredient.getName());
        ingredient.setQuantity(ingredient.getQuantity());
        ingredient.setUnit(ingredient.getUnit());
        return ingredient;
    }
}
