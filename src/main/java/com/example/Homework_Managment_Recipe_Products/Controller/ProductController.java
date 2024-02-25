package com.example.Homework_Managment_Recipe_Products.Controller;

import com.example.Homework_Managment_Recipe_Products.Entity.CategoryProducts;
import com.example.Homework_Managment_Recipe_Products.Entity.Product;
import com.example.Homework_Managment_Recipe_Products.Repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    private ProductRepository productRepository;
    private ProductService productService;

    public ProductController(ProductRepository productRepository,
                             ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }

    @ModelAttribute("categories")
    public List<CategoryProducts> getCategories() {
        return Arrays.asList(CategoryProducts.values());
    }

    @GetMapping("/product/create")
    public String createProduct(Model model) {
        model.addAttribute("product", new Product());
        return "create-product";
    }

    @PostMapping("/product/create")
    public ModelAndView createPostProduct(@Valid @ModelAttribute Product product,
                                          Model model, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        return productService.createPostProduct(product, model, bindingResult, redirectAttributes);

    }

    @GetMapping("/product")
    public String showAllProducts( Model model) {

        model.addAttribute("products", productRepository.findAll());
        return "products";
    }

    @GetMapping("/product/update/{id}")
    public String showUpdateProductForm(@PathVariable Long id, Model model) {
        Product product = productRepository.findById(id).orElseThrow(null);
        model.addAttribute("product", product);
        return "update-product";
    }

    @PostMapping("/product/update")
    public String updateProduct(@Valid @ModelAttribute Product product) {
        productRepository.save(product);
        return "redirect:/product";
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }



}
