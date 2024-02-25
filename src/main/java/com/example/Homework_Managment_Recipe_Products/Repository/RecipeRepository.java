package com.example.Homework_Managment_Recipe_Products.Repository;

import com.example.Homework_Managment_Recipe_Products.Entity.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
