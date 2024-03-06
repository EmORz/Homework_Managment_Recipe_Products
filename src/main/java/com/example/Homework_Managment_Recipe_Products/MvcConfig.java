package com.example.Homework_Managment_Recipe_Products;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/product/create").setViewName("create-product");
        registry.addViewController("/product").setViewName("products");
        registry.addViewController("/product/update/{id}").setViewName("update-product");
        registry.addViewController("/recipe").setViewName("recipes");
        registry.addViewController("/recipe/create").setViewName("create-recipe");

        registry.addViewController("/login").setViewName("login");
    }

}


