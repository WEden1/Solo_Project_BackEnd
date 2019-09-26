package com.qa.controllers;

import com.qa.models.Spells;
import com.qa.repository.SpellsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class SpellsController {

    @Autowired
    public SpellsRepository repo;

    @RequestMapping(value = "spells", method = RequestMethod.GET)
    public List<Spells> listAllSpells(){
        return repo.findAll();
    }

    @RequestMapping(value = "spells", method = RequestMethod.POST)
    public Spells addSpell(@RequestBody Spells spells){
        return repo.saveAndFlush(spells);
    }

    @RequestMapping(value = "spells/{id}", method = RequestMethod.GET)
    public Spells getSpell(@PathVariable Long id){
        return repo.findOne(id);
    }

    @RequestMapping(value = "spells/{id}", method = RequestMethod.DELETE)
    public Spells deleteSpell(@PathVariable Long id){
        Spells existing = repo.findOne(id);
        repo.delete(existing);
        return existing;
    }

    @RequestMapping(value = "spells/{id}",method = RequestMethod.PUT)
    public Spells updateEntry(@PathVariable Long id,@RequestBody Spells spells){
        Spells existing = repo.findOne(id);
        existing.setSpell(spells.getSpell());
        existing.setDescription(spells.getDescription());
        repo.saveAndFlush(existing);
        return existing;
    }
}