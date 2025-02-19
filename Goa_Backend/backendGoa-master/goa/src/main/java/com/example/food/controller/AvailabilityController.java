package com.example.food.controller;

import com.example.food.entity.Availability;
import com.example.food.service.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/availability")
public class AvailabilityController {

    @Autowired
    private AvailabilityService availabilityService;
//http://localhost:8081/availability/add
    @PostMapping("/add")
    public ResponseEntity<Availability> addAvailability(@RequestBody Availability availability) {
        return ResponseEntity.ok(availabilityService.saveAvailability(availability));
    }
//http://localhost:8081/availability/1
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Availability>> getAvailabilityById(@PathVariable Long id) {
        return ResponseEntity.ok(availabilityService.getAvailabilityById(id));
    }
//http://localhost:8081/availability/all
    @GetMapping("/all")
    public ResponseEntity<List<Availability>> getAllAvailability() {
        return ResponseEntity.ok(availabilityService.getAllAvailability());
    }

    //http://localhost:8081/availability/1
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAvailability(@PathVariable Long id) {
        availabilityService.deleteAvailability(id);
        return ResponseEntity.ok("Availability record deleted successfully");
    }
}
