//package com.example.food.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.example.food.entity.Hotel;
//
//public interface HotelRepository extends JpaRepository<Hotel, Long> {
//
//}



package com.example.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.food.entity.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    boolean existsByName(String name);  // Checks if a hotel with the same name exists
}


