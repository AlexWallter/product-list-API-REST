package com.example.product_list_page.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.product_list_page.model.Meal;

@Repository
public interface MealRepository extends CrudRepository<Meal, Long>{
    boolean existsByName(String mealName);
}
