package com.qa.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ingredients {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String ingredient1;
    String ingredient2;
    String ingredient3;
    int amount;

    public String getIngredient1() {
        return ingredient1;
    }

    public void setIngredient1(String ingredient1) {
        this.ingredient1 = ingredient1;
    }

    public String getIngredient2() {
        return ingredient2;
    }

    public void setIngredient2(String ingredient2) {
        this.ingredient2 = ingredient2;
    }

    public String getIngredient3() {
        return ingredient3;
    }

    public void setIngredient3(String ingredient3) {
        this.ingredient3 = ingredient3;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
