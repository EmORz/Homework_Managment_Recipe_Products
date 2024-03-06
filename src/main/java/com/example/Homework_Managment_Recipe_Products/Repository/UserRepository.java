package com.example.Homework_Managment_Recipe_Products.Repository;


import com.example.Homework_Managment_Recipe_Products.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {
    public User getUserByUsername(@Param("username") String username);

}
