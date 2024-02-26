package com.example.Homework_Managment_Recipe_Products.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 2, max = 50, message = "Името на продукта трябва да е между 2 и 50 символа")
    private String name;

    private CategoryProducts categoryProducts;

    public Product(String name, CategoryProducts categoryProducts) {
        this.name = name;
        this.categoryProducts = categoryProducts;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryProducts getCategoryProducts() {
        return categoryProducts;
    }

    public void setCategoryProducts(CategoryProducts categoryProducts) {
        this.categoryProducts = categoryProducts;
    }
}
