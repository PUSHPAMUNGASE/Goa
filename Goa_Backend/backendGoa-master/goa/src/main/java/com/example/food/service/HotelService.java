package com.example.food.service;



import com.example.food.entity.Hotel;
import com.example.food.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;
//
//    public Hotel saveHotel(Hotel hotel) {
////        if (hotelRepository.existsByHotelName(hotel.getName())) {
////            throw new RuntimeException("Hotel with this name already exists.");
////        }
//        return hotelRepository.save(hotel);
//    }
	
	
	 public Hotel saveHotel(Hotel hotel) {
	        if (hotelRepository.existsByName(hotel.getName())) {
	            throw new RuntimeException("Hotel with this name already exists.");
	        }
	        return hotelRepository.save(hotel);
	    }
	 
	 
	 
	 public Hotel updateHotel(Long id, Hotel hotelDetails) {
	        Optional<Hotel> optionalHotel = hotelRepository.findById(id);

	        if (optionalHotel.isPresent()) {
	            Hotel existingHotel = optionalHotel.get();
	            existingHotel.setName(hotelDetails.getName());
	            existingHotel.setLocation(hotelDetails.getLocation());
	            existingHotel.setContact(hotelDetails.getContact());

	            return hotelRepository.save(existingHotel);
	        } else {
	            throw new RuntimeException("Hotel with ID " + id + " not found.");
	        }
	    }

    public Optional<Hotel> getHotelById(Long id) {
        return hotelRepository.findById(id);
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }
}

