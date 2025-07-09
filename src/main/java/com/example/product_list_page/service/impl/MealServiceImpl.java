package com.example.product_list_page.service.impl;

import java.util.NoSuchElementException;

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
    public Meal getMealById(Long id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void addMeal(Meal meal) {
        if (repository.existsByName(meal.getName())) {
            throw new IllegalArgumentException("this meal already exists"); 
        }
        repository.save(meal);
    }

    @Override
    public void removeMeal(Long id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException();
        }
        repository.deleteById(id);
    }
    
}
