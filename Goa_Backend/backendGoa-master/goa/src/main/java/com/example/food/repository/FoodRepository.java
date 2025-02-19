package com.example.food.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.food.entity.Food;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.food.entity.Food;
import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, Long> {
	List<Food> findByCategoryId(Long categoryId);
    List<Food> findByHotelId(Long hotelId);
    List<Food> findByCategoryIdAndHotelId(Long categoryId, Long hotelId);
    
    
    
  

        
    }


