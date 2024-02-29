package com.example.Homework_Managment_Recipe_Products.Controller;

import com.example.Homework_Managment_Recipe_Products.Entity.Product;
import com.example.Homework_Managment_Recipe_Products.Repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ModelAndView createPostProduct(Product product,
                                          Model model,
                                          BindingResult bindingResult, RedirectAttributes redirectAttributes){

        System.out.println("...");
        if (bindingResult.hasErrors()) {
            List<FieldError> nameErrors = bindingResult.getFieldErrors("name");
            model.addAttribute("errors", nameErrors);
            model.addAttribute("product", new Product());
            return new ModelAndView("create-product");
        }

        productRepository.save(product);
        redirectAttributes.addFlashAttribute("successMessage", "Продуктът е създаден успешно!");

        return new ModelAndView("redirect:/product");
    }

}
