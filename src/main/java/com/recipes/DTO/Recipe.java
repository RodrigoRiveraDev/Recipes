package com.recipes.DTO;

import java.util.List;

public class Recipe {

    private int id;
    private List<Ingredient> ingredients;
    private String howElaborate;
    private int userId;

    public Recipe() {
        ingredients = null;
        howElaborate = "";
    }

    public Recipe(List<Ingredient> ingredients, String howElaborate) {
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

    public boolean hasAllParameters() {
        return  !howElaborate.isEmpty() &&
                ingredients.size() > 0;
    }

    public boolean hasId(int id) {
        return this.id == id;
    }

    public void updateInfo(Recipe dataToUpdate) {
        if(!dataToUpdate.getHowElaborate().isEmpty()) {
            this.howElaborate = dataToUpdate.getHowElaborate();
        }
        if(dataToUpdate.getIngredients().size() > 0) {
            this.ingredients = dataToUpdate.getIngredients();
        }
    }

    public boolean isOwner(int id) {
        return this.userId == id;
    }

    @Override
    public boolean equals(Object obj) {
        Recipe other = (Recipe) obj;
        return  this.howElaborate.equals(other.howElaborate) &&
                this.ingredients.equals(other.ingredients) &&
                this.id == other.getId();
    }
}
