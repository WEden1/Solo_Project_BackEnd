package com.qa.controllers;

import com.qa.models.Ingredients;
import com.qa.repository.HubbleBubbleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class IngredientsController {

    @Autowired
    private HubbleBubbleRepository repo;

    @RequestMapping(value = "ingredients", method = RequestMethod.GET)
    public List<Ingredients> listAllIngredients(){
        return repo.findAll();
    }

    @RequestMapping(value = "ingredients", method = RequestMethod.POST)
    public Ingredients addNote(@RequestBody Ingredients ingredients){
        return repo.saveAndFlush(ingredients);
    }

    @RequestMapping(value = "ingredients/{id}", method = RequestMethod.GET)
    public Ingredients getNote(@PathVariable Long id){
        return repo.findOne(id);
    }

    @RequestMapping(value = "ingredients/{id}", method = RequestMethod.DELETE)
    public Ingredients deleteNote(@PathVariable Long id){
        Ingredients existing = repo.findOne(id);
        repo.delete(existing);
        return existing;
    }
}
