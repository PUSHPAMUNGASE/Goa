package com.example.food.controller;

import com.example.food.entity.Food;
import com.example.food.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @PostMapping("/add")
    public ResponseEntity<Food> addFood(@RequestBody Food food) {
    	
        return ResponseEntity.ok(foodService.saveFood(food));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Food>> getFoodById(@PathVariable Long id) {
        return ResponseEntity.ok(foodService.getFoodById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Food>> getAllFoods() {
        return ResponseEntity.ok(foodService.getAllFoods());
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Food>> getFoodsByHotelId(@PathVariable Long hotelId) {
        return ResponseEntity.ok(foodService.getFoodsByHotelId(hotelId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFood(@PathVariable Long id) {
        foodService.deleteFood(id);
        return ResponseEntity.ok("Food deleted successfully");
    }
}
