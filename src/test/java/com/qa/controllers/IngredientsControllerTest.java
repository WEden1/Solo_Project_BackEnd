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
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;


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
            ingredients.setAmount("22");
            ingredients.setIngredient("Apple");

            when(repo.findAll()).thenReturn(ingredientsList);
            ingredientsController.listAllIngredients();
        }

        @Test
        public void testGetIngredients(){
            Ingredients ingredients = new Ingredients();
            ingredients.setIngredient("bannana");

            when(repo.findOne(1L)).thenReturn(ingredients);
            ingredientsController.getIngredients(1L);
        }

        @Test
        public void testDeleteIngredients(){
            Ingredients ingredients = new Ingredients();
            ingredients.setIngredient("bamnnana");
            repo.findOne(1L);
            ingredientsController.deleteIngredients(1L);
            when(!repo.exists(1L)).thenReturn(true);
        }

        @Test
        public void testAddIngredients(){
            Ingredients ingredient = new Ingredients();
            ingredient.setIngredient("apple");
            ingredientsController.addIngredients(ingredient);
            when(repo.exists(1L)).thenReturn(true);
        }




    }
