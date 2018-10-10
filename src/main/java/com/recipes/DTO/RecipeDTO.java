package com.recipes.DTO;

import com.recipes.Entities.Ingredient;

import java.util.List;

public class RecipeDTO {

    private int id;
    private List<Ingredient> ingredients;
    private String howElaborate;
    private int userId;

    public RecipeDTO() {
        ingredients = null;
        howElaborate = "";
    }

    public RecipeDTO(List<Ingredient> ingredients, String howElaborate) {
        this.ingredients = ingredients;
        this.howElaborate = howElaborate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHowElaborate() {
        return howElaborate;
    }

    public void setHowElaborate(String howElaborate) {
        this.howElaborate = howElaborate;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private String ingredientsToJSON() {
        StringBuilder sb = new StringBuilder("[");
        boolean first = true;
        for(Ingredient ingredient: ingredients) {
            if(first) {
                first = false;
            }
            else {
                sb.append(",");
            }
            sb.append(String.format("{" +
                    "\"name\": \"%s\"," +
                    "\"quantity\": \"%s\"," +
                    "\"unit\": \"%s\"" +
                    "}", ingredient.getName(), ingredient.getQuantity(), ingredient.getUnit()));
        }
        return sb.toString()+"]";
    }

    @Override
    public String toString() {
        return String.format("{\"howElaborate\":\"%s\", \"ingredients\":%s}", howElaborate, ingredientsToJSON());
    }
}
