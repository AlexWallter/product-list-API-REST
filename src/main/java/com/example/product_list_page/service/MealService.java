package com.example.product_list_page.service;

import java.util.Optional;

import com.example.product_list_page.model.Meal;

public interface MealService {
    Iterable<Meal> getAllMeals();
    Optional<Meal> getMealById(Long id);
    void addMeal(Meal meal);
    void removeMeal(Long id);
}
