package com.example.Homework_Managment_Recipe_Products.Controller;

import com.example.Homework_Managment_Recipe_Products.Entity.CategoryProducts;
import com.example.Homework_Managment_Recipe_Products.Entity.CategoryRecipe;
import com.example.Homework_Managment_Recipe_Products.Entity.Product;
import com.example.Homework_Managment_Recipe_Products.Entity.Recipe;

@org.springframework.stereotype.Service
public class Service {

    /* SALAD,
    SOUP,
    MAIN,
    DESSERT*/
    public Integer calculateRating(Recipe recipe){
        int rating = 3;

        switch (recipe.getCategoryRecipe()){
            case SOUP:
                for (Product product: recipe.getProducts()
                     ) {
                    if (product.getCategoryProducts().equals(CategoryProducts.VEGETABLES)) {
                        rating+=1;
                    } else if (product.getCategoryProducts().equals(CategoryProducts.FRUIT)) {
                        rating-=2;
                    }
                }
                break;
            case SALAD:
                for (Product product: recipe.getProducts()
                ) {
                    if (product.getCategoryProducts().equals(CategoryProducts.FRUIT) || product.getCategoryProducts().equals(CategoryProducts.VEGETABLES) ) {
                        rating+=1;
                    }
                }
                break;
            case DESSERT:
                for (Product product: recipe.getProducts()
                ) {
                    if (product.getCategoryProducts().equals(CategoryProducts.FRUIT) ) {
                        rating+=1;
                    } else if ( product.getCategoryProducts().equals(CategoryProducts.VEGETABLES)) {
                        rating-=2;
                    }
                }
                if (recipe.getProducts().stream().anyMatch(product -> product.getName().equals("шоколад"))) {
                    rating+=3;
                }
                break;
            case MAIN:
                // трябва да се измисли формула
                break;
        }
        return rating;
    }
}
