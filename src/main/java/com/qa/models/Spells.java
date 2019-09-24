package com.qa.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Spells {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String spell;
    private String description;

    @OneToMany
    @JsonIgnore
    private Set<Ingredients> containsIngredients = new HashSet<Ingredients>();

    public Set<Ingredients> getContainsIngredients() {
        return containsIngredients;
    }

    public void setContainsIngredients(Set<Ingredients> containsIngredients) {
        this.containsIngredients = containsIngredients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
