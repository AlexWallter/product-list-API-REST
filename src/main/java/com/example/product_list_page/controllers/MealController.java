package com.example.product_list_page.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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

    private final MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Meal>> getAllMeals() {
        return  ResponseEntity.ok(mealService.getAllMeals());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meal> getMealId(@PathVariable Long id) {
        return ResponseEntity.ok(mealService.getMealById(id));
    }

    @PostMapping
    public ResponseEntity<Meal> addMeal(@RequestBody Meal meal) {
        System.out.println(meal.toString());
        mealService.addMeal(meal);
        return ResponseEntity.ok(meal);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> upDatePrice(@PathVariable Long id, double newPrice) {
        String message = mealService.updateMealPrice(id, newPrice);
        return ResponseEntity.ok(message);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeMeal(@PathVariable Long id) {
        mealService.removeMeal(id);
        return ResponseEntity.ok().build();
    }
}
