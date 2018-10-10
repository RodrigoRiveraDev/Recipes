package com.recipes.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
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

    public Recipe() {
        ingredients = new ArrayList<>();
    }

    public Recipe(String howElaborate, List<Ingredient> ingredients) {
        this.howElaborate = howElaborate;
        this.ingredients = ingredients;
    }

    /**
     * @param id param to replace the current id value
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @param howElaborate param to replace the current howElaborate value
     */
    public void setHowElaborate(String howElaborate) {
        this.howElaborate = howElaborate;
    }

    /**
     * @param ingredients param to replace the current ingredient list
     */
    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * @param userId param to replace the current userId value
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     * @return It will return the current object id
     */
    public long getId() {
        return id;
    }

    /**
     * @return It will return the current object ingredients list
     */
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    /**
     * @return It will return the current object howElaborate
     */
    public String getHowElaborate() {
        return howElaborate;
    }

    /**
     * @return It will return the current object userId
     */
    public long getUserId() {
        return userId;
    }


}

