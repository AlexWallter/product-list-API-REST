package com.example.product_list_page.service;

import com.example.product_list_page.model.Meal;

public interface MealService {
    Iterable<Meal> getAllMeals();
    Meal getMealById(Long id);
    void addMeal(Meal meal);
    void removeMeal(Long id);
    String updateMealPrice(Long id, double newPrice);
}
