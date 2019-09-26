package com.qa.controllers;

import com.qa.models.Ingredients;
import com.qa.repository.IngredientsRepository;
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
    public class IngredientsControllerTest {
        @InjectMocks
        private IngredientsController ingredientsController;

        @Mock
        private IngredientsRepository repo;

        @LocalServerPort
        private int port;

        @Autowired
        private TestRestTemplate restTemplate;

        @Test
        public void testGetAllIngredients(){
            List<Ingredients> ingredientsList = new ArrayList<>();
            Ingredients ingredients = new Ingredients();
            ingredients.setIngredient1("black dog");
            ingredients.setIngredient2("human foot");
            ingredients.setIngredient3("newt eye");
            when(repo.findAll()).thenReturn(ingredientsList);
            ingredientsController.listAllIngredients();
        }

        @Test
        public void testAddIngredients(){
            ArrayList<String> food = new ArrayList<String>();
            Ingredients ingredient = new Ingredients();
            ingredient.setIngredient2("cat");
            ingredientsController.addIngredients(ingredient);
            when(repo.exists(1L)).thenReturn(true);
        }

        @Test
        public void testGetIngredients(){
            ArrayList<String> foods = new ArrayList<String>();
            Ingredients ingredients = new Ingredients();
            ingredients.setIngredient1("apple");

            when(repo.findOne(1L)).thenReturn(ingredients);
            ingredientsController.getIngredients(1L);
        }

        @Test
        public void testDeleteIngredients(){
            ArrayList<String> food = new ArrayList<String>();
            Ingredients ingredients = new Ingredients();
            ingredients.setIngredient1("apple");
            repo.findOne(1L);
            ingredientsController.deleteIngredients(1L);
            when(!repo.exists(1L)).thenReturn(true);
        }






    }
