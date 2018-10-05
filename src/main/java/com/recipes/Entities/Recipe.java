package com.recipes.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @NotEmpty
    private String howElaborate;
    @ManyToOne
    private User user;
    @NotNull
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Ingredient> ingredients;

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setHowElaborate(String howElaborate) {
        this.howElaborate = howElaborate;
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return id;
    }

    public String getHowElaborate() {
        return howElaborate;
    }
}

