package com.recipes.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    @NotEmpty
    private String name;
    @NotNull
    private double quantity;
    @NotEmpty
    private String unit;

    public Ingredient() {}

    public Ingredient(String name, double quantity, String unit) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }

    /**
     * @param id param to replace the current id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @param name param to replace the current name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param quantity param to replace the current quantity
     */
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    /**
     * @param unit param to replace the current unity
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * @return It will return the current object id
     */
    public long getId() {
        return id;
    }

    /**
     * @return It will return the current object name
     */
    public String getName() {
        return name;
    }

    /**
     * @return It will return the current object quantity
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * @return It will return the current object unit
     */
    public String getUnit() {
        return unit;
    }
}
