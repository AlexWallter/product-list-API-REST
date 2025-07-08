package com.example.product_list_page.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product_list_page.model.Meal;
import com.example.product_list_page.repository.MealRepository;
import com.example.product_list_page.service.MealService;

@Service
public class MealServiceImpl implements MealService {
    @Autowired
    MealRepository repository;

    @Override
    public Iterable<Meal> getAllMeals() {
        return repository.findAll();
    }

    @Override
    public Optional<Meal> getMealById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void addMeal(Meal meal) {
        repository.save(meal);
    }

    @Override
    public void removeMeal(Long id) {
        repository.deleteById(id);
    }
    
}
