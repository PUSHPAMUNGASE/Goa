package com.example.food.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.food.entity.FoodImage;

public interface FoodImageRepository extends JpaRepository<FoodImage, Long> {
	List<FoodImage> findByFoodId(Long foodId);
}
