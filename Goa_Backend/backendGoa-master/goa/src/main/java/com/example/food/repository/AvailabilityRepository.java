package com.example.food.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.food.entity.Availability;

public interface AvailabilityRepository extends JpaRepository<Availability, Long> {
	  List<Availability> findByHotelId(Long hotelId);
	    List<Availability> findByFoodId(Long foodId);
	    Optional<Availability> findByHotelIdAndFoodId(Long hotelId, Long foodId);
}
