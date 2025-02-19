//package com.example.food.repository;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.example.food.entity.HotelImage;
//
//public interface HotelImageRepository extends JpaRepository<HotelImage, Long> {
//	List<HotelImage> findByHotelId(Long hotelId);
//	///Optional<HotelImage> findByHotelId(Long hotelId);
//}
//  


package com.example.food.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.food.entity.Hotel;
import com.example.food.entity.HotelImage;

public interface HotelImageRepository extends JpaRepository<HotelImage, Long> {
	List<HotelImage> findByHotelId(Long hotelId);
    Optional<HotelImage> findByHotel(Hotel hotel);
    boolean existsByHotel(Hotel hotel);
}
