package com.example.food.service;



import com.example.food.entity.Food;
import com.example.food.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public Food saveFood(Food food) {
        return foodRepository.save(food);
    }

    public Optional<Food> getFoodById(Long id) {
        return foodRepository.findById(id);
    }

    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    
    
    
    public List<Food> getFoodsByHotelId(Long hotelId) {
        return foodRepository.findByHotelId(hotelId);
    }

    public void deleteFood(Long id) {
        foodRepository.deleteById(id);
    }
}
