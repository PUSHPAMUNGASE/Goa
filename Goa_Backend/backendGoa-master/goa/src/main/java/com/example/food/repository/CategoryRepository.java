package com.example.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.food.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
