package com.example.food.service;


import com.example.food.entity.Availability;
import com.example.food.repository.AvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvailabilityService {
    
    @Autowired
    private AvailabilityRepository availabilityRepository;

    public Availability saveAvailability(Availability availability) {
        return availabilityRepository.save(availability);
    }

    public Optional<Availability> getAvailabilityById(Long id) {
        return availabilityRepository.findById(id);
    }

    public List<Availability> getAllAvailability() {
        return availabilityRepository.findAll();
    }

    public void deleteAvailability(Long id) {
        availabilityRepository.deleteById(id);
    }
}
