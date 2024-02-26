package com.example.Homework_Managment_Recipe_Products.Controller;

import com.example.Homework_Managment_Recipe_Products.Entity.Product;
import com.example.Homework_Managment_Recipe_Products.Entity.Recipe;
import com.example.Homework_Managment_Recipe_Products.Repository.RecipeRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Set;

@Service
public class RecipeService {

    private RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public ModelAndView createRecipePost(Recipe recipe, BindingResult bindingResult, Model model){

        Set<Product> selectedProducts = recipe.getProducts();
        if (bindingResult.hasErrors()) {
            List<FieldError> nameErrors = bindingResult.getFieldErrors("name");
            model.addAttribute("errors", nameErrors);
            return new ModelAndView("create-product");
        }
        recipe.setProducts( selectedProducts);
        recipeRepository.save(recipe);
        return new ModelAndView( "redirect:/recipe");
    }
}
