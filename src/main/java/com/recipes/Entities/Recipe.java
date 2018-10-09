package com.recipes.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    @NotEmpty(message = "howElaborate must not be empty")
    private String howElaborate;
    private long userId;
    @NotNull
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Ingredient> ingredients;

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setHowElaborate(String howElaborate) {
        this.howElaborate = howElaborate;
    }

    public long getId() {
        return id;
    }

    public String getHowElaborate() {
        return howElaborate;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}

