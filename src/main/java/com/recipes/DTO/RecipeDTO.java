package com.recipes.DTO;

import com.recipes.Entities.Ingredient;

import java.util.List;

public class RecipeDTO {

    private int id;
    private List<Ingredient> ingredients;
    private String howElaborate;
    private int userId;

    /**
     * Default constructor needed for the RecipeControllerTest
     */
    public RecipeDTO() { }

    public RecipeDTO(List<Ingredient> ingredients, String howElaborate) {
        this.ingredients = ingredients;
        this.howElaborate = howElaborate;
    }

    /**
     * @return It will return the object id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id It will set the object id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return It will return the attribute howElaborate value
     */
    public String getHowElaborate() {
        return howElaborate;
    }

    /**
     * @return It will return the ingredients list
     */
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    /**
     * private function to convert the Ingredients to JSON format
     * @return It will retrieve the ingredients list in a JSON format
     */
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

    /**
     * @return It will return the RecipeDTO as a String with Json format
     */
    @Override
    public String toString() {
        return String.format("{\"howElaborate\":\"%s\", \"ingredients\":%s}", howElaborate, ingredientsToJSON());
    }
}
