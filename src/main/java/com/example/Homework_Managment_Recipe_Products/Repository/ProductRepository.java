package com.example.Homework_Managment_Recipe_Products.Repository;

import com.example.Homework_Managment_Recipe_Products.Entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Set<Product> findAllById(Long ids);
}
