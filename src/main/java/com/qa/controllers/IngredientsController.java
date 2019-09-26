package com.qa.controllers;

import com.qa.models.Ingredients;
import com.qa.repository.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class IngredientsController {

    @Autowired
    private IngredientsRepository repo;

    @RequestMapping(value = "ingredients", method = RequestMethod.GET)
    public List<Ingredients> listAllIngredients(){
        return repo.findAll();
    }

    @RequestMapping(value = "ingredients", method = RequestMethod.POST)
    public Ingredients addIngredients(@RequestBody Ingredients ingredientsPost){
        return repo.saveAndFlush(ingredientsPost);
    }

    @RequestMapping(value = "ingredients/{id}", method = RequestMethod.GET)
    public Ingredients getIngredients(@PathVariable Long id){
        return repo.findOne(id);
    }

    @RequestMapping(value = "ingredients/{id}", method = RequestMethod.DELETE)
    public Ingredients deleteIngredients(@PathVariable Long id){
        Ingredients existing = repo.findOne(id);
        repo.delete(existing);
        return existing;
    }

    @RequestMapping(value = "ingredients/{id}",method = RequestMethod.PUT)
    public Ingredients updateEntry(@PathVariable Long id,@RequestBody Ingredients ingredients){
        Ingredients existing = repo.findOne(id);
        existing.setPotion(ingredients.getPotion());
        existing.setIngredient1(ingredients.getIngredient1());
        existing.setIngredient2(ingredients.getIngredient2());
        existing.setIngredient3(ingredients.getIngredient3());
        existing.setId(ingredients.getId());
        repo.saveAndFlush(existing);
        return existing;
    }


}
