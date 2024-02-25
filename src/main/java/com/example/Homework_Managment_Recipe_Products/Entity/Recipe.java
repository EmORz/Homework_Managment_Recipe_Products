package com.example.Homework_Managment_Recipe_Products.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Size(min = 2, max = 50, message = "Името на рецептата трябва да е между 2 и 50 символа")
    private String name;

    @Enumerated(EnumType.STRING)
    private CategoryRecipe categoryRecipe;


    @Size(min = 10, max = 250, message = "Описанието на рецептата трябва да е между 102 и 50 символа")
    private String description;

    @ManyToMany
    private Set<Product> products;

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

    public CategoryRecipe getCategoryRecipe() {
        return categoryRecipe;
    }

    public void setCategoryRecipe(CategoryRecipe categoryRecipe) {
        this.categoryRecipe = categoryRecipe;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
