package com.qa.controllers;

import com.qa.models.Spells;
import com.qa.repository.SpellsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpellsControllerTests {
    @InjectMocks
    private SpellsController spellsController;

    @Mock
    private SpellsRepository repo;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetAllSpells(){
        List<Spells> spellsList = new ArrayList<>();
        Spells spells = new Spells();
        spells.setSpell("Fire Power");
        spells.setDescription("burn in hell");
        when(repo.findAll()).thenReturn(spellsList);
        spellsController.listAllSpells();
    }

    @Test
    public void testAddSpell(){
        Spells spells = new Spells();
        spells.setSpell("Water Power");
        spells.setDescription("you'll float down here");
        spellsController.addSpell(spells);
        when(repo.exists(1L)).thenReturn(true);
    }

    @Test
    public void testGetSpell(){
        Spells spell = new Spells();
        spell.setSpell("Wind Power");
        spell.setDescription("leave 'm blowing in the wind");
        when(repo.findOne(1L)).thenReturn(spell);
        spellsController.getSpell(1L);
    }

    @Test
    public void testDeleteSpell(){
        Spells spell = new Spells();
        spell.setSpell("Earth Power");
        spell.setDescription("eat soil");
        repo.findOne(1L);
        spellsController.deleteSpell(1L);
        when(!repo.exists(1L)).thenReturn(true);
    }






}
