package com.example.Homework_Managment_Recipe_Products.Controller;

import com.example.Homework_Managment_Recipe_Products.Entity.CategoryRecipe;
import com.example.Homework_Managment_Recipe_Products.Entity.Product;
import com.example.Homework_Managment_Recipe_Products.Entity.Recipe;
import com.example.Homework_Managment_Recipe_Products.Repository.ProductRepository;
import com.example.Homework_Managment_Recipe_Products.Repository.RecipeRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

@Controller
public class RecipeController {

    private RecipeRepository recipeRepository;
    private ProductRepository productRepository;

    public RecipeController(RecipeRepository recipeRepository, ProductRepository productRepository) {
        this.recipeRepository = recipeRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/recipe")
    public String showAllRecipes( Model model) {

        Iterable<Recipe> recipes= recipeRepository.findAll();

        model.addAttribute("recipes", recipes);
        return "recipes";
    }

    @ModelAttribute("categories")
    public List<CategoryRecipe> getCategories() {
        return Arrays.asList(CategoryRecipe.values());
    }
    @GetMapping("/recipe/create")
    public String createRecipeForm(Model model) {
        model.addAttribute("recipe", new Recipe());
        model.addAttribute("products", productRepository.findAll());
        return "create-recipe";
    }

    @PostMapping("/recipe/create")
    public String createRecipePost(@Valid @ModelAttribute Recipe recipe){

        Set<Product> selectedProducts = recipe.getProducts();

        recipe.setProducts( selectedProducts);
        recipeRepository.save(recipe);
        return "redirect:/recipe";
    }
}
