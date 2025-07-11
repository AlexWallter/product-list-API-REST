package com.example.product_list_page.service.impl;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.product_list_page.model.Meal;
import com.example.product_list_page.repository.MealRepository;
import com.example.product_list_page.service.MealService;

@Service
public class MealServiceImpl implements MealService {

    private final MealRepository repository;

    public MealServiceImpl(MealRepository repository) {
        this.repository = repository;
    }

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

    @Override
    public String updateMealPrice(Long id, double newPrice) {
        Optional<Meal> temp = repository.findById(id);

        if (temp.isPresent()) {
            Meal toBeUpdated = temp.get();
            double oldPrice = toBeUpdated.getPrice();
            String message = "the price was updated from " + oldPrice + " to " + newPrice;
            
            toBeUpdated.setPrice(newPrice);
            repository.save(toBeUpdated);
            return message;
        }
        else {
            throw new NoSuchElementException();
        }
    }
    
}
