package com.example.Homework_Managment_Recipe_Products.Controller;

import com.example.Homework_Managment_Recipe_Products.Entity.CategoryProducts;
import com.example.Homework_Managment_Recipe_Products.Entity.CategoryRecipe;
import com.example.Homework_Managment_Recipe_Products.Entity.Product;
import com.example.Homework_Managment_Recipe_Products.Entity.Recipe;
import com.example.Homework_Managment_Recipe_Products.Repository.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ServiceTest {

    @InjectMocks
    Service service;

    @Mock
    RecipeRepository recipeRepository;

    @Test
    public void testCalculateRatingForSoup(){
        Recipe recipe = new Recipe();
        recipe.setCategoryRecipe(CategoryRecipe.SOUP);

        Set<Product> products = new HashSet<>();
        products.add(new Product("домат",CategoryProducts.VEGETABLES));
        products.add(new Product("ябълка",CategoryProducts.FRUIT));
        recipe.setProducts(products);

//        Mockito.when(recipeRepository.findById(1L)).thenReturn(Optional.of(recipe));

        int rating = service.calculateRating(recipe);

        assertEquals(2, rating);
        assertNotEquals(3, rating);
    }

    @Test
    public void testCalculateRatingForSalad(){
        Recipe recipe = new Recipe();
        recipe.setCategoryRecipe(CategoryRecipe.SALAD);
        Set<Product> products = new HashSet<>();
        products.add(new Product("домат",CategoryProducts.VEGETABLES));
        products.add(new Product("ябълка",CategoryProducts.FRUIT));
        recipe.setProducts(products);

//        Mockito.when(recipeRepository.findById(1L)).thenReturn(Optional.of(recipe));
        int rating = service.calculateRating(recipe);

        assertEquals(5, rating);
        assertNotEquals(3, rating);
    }

    @Test
    public void testCalculateRatingForDessert(){
        Recipe recipe = new Recipe();
        recipe.setCategoryRecipe(CategoryRecipe.DESSERT);
        Set<Product> products = new HashSet<>();
        products.add(new Product("домат",CategoryProducts.VEGETABLES));
        products.add(new Product("ябълка",CategoryProducts.FRUIT));
        recipe.setProducts(products);

//        Mockito.when(recipeRepository.findById(1L)).thenReturn(Optional.of(recipe));
        int rating = service.calculateRating(recipe);

        assertEquals(2, rating);
        assertNotEquals(3, rating);
    }
    @Test
    public void testCalculateRatingForDessertChocolate(){
        Recipe recipe = new Recipe();
        recipe.setCategoryRecipe(CategoryRecipe.DESSERT);
        Set<Product> products = new HashSet<>();
        products.add(new Product("домат",CategoryProducts.VEGETABLES));
        products.add(new Product("ябълка",CategoryProducts.FRUIT));
        products.add(new Product("шоколад",CategoryProducts.SPICES));
        recipe.setProducts(products);

//        Mockito.when(recipeRepository.findById(1L)).thenReturn(Optional.of(recipe));
        int rating = service.calculateRating(recipe);

        assertEquals(5, rating);
        assertNotEquals(3, rating);
    }

}