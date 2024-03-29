package com.example.Homework_Managment_Recipe_Products.Controller;

import com.example.Homework_Managment_Recipe_Products.Entity.CategoryProducts;
import com.example.Homework_Managment_Recipe_Products.Entity.Product;
import com.example.Homework_Managment_Recipe_Products.Repository.ProductRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.apache.maven.wagon.ResourceDoesNotExistException;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/product/create")
    public ModelAndView createPostProduct(@Valid @ModelAttribute Product product,
                                          Model model, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        return productService.createPostProduct(product, model, bindingResult, redirectAttributes);

    }

    @GetMapping("/product")
    public String showAllProducts( Model model) {
        model.addAttribute("products", productService.findAllProducts());
        return "products";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/product/update/{id}")
    public String showUpdateProductForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes)  {

        try {
            model.addAttribute("product", productService.findProductById(id));
            return "update-product";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Продуктът не е намерен с ID: " + id);
            return "redirect:/product";
        }

    }

    @PostMapping("/product/update")
    public String updateProduct(@Valid @ModelAttribute Product product) {
        productRepository.save(product);
        return "redirect:/product";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }



}
