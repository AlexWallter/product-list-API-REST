package com.example.product_list_page.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product_list_page.model.Meal;
import com.example.product_list_page.service.MealService;


@RestController
@RequestMapping("/meal")
public class MealController {
    @Autowired
    MealService mealService;

    @GetMapping
    public ResponseEntity<Iterable<Meal>> getAllMeals() {
        return  ResponseEntity.ok(mealService.getAllMeals());
    }

    @GetMapping("/{id}")
    public Optional<Meal> getMealId(@PathVariable Long id) {
        return mealService.getMealById(id);
    }

    @PostMapping
    public ResponseEntity<Meal> addMeal(@RequestBody Meal meal) {
        System.out.println(meal.toString());
        mealService.addMeal(meal);
        return ResponseEntity.ok(meal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeMeal(@PathVariable Long id) {
        mealService.removeMeal(id);
        return ResponseEntity.ok().build();
    }
}
