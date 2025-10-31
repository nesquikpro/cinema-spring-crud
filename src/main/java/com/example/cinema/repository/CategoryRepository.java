package com.example.cinema.repository;

import com.example.cinema.models.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findByName(String name);
    List<Category> findByNameContaining(String name);

    Category findCategoryByName(String name);
}
