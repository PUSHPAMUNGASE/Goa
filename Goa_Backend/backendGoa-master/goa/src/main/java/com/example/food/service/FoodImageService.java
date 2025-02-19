//package com.example.food.service;
//
//
//
//import com.example.food.entity.FoodImage;
//import com.example.food.repository.FoodImageRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.List;
//import java.util.Optional;
//
//
//@Service
//public class FoodImageService {
//
//    @Autowired
//    private FoodImageRepository foodImageRepository;
//
//    public FoodImage saveFoodImage(FoodImage foodImage) {
//        return foodImageRepository.save(foodImage);
//    }
//
//    public List<FoodImage> getFoodImagesByFoodId(Long foodId) {
//        return foodImageRepository.findByFoodId(foodId);
//    }
//
//    public void deleteFoodImage(Long id) {
//        foodImageRepository.deleteById(id);
//    }
//}


package com.example.food.service;


import com.example.food.entity.Food;
import com.example.food.repository.FoodRepository;
import com.example.food.entity.FoodImage;
import com.example.food.entity.Hotel;
import com.example.food.entity.HotelImage;
import com.example.food.repository.FoodImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Optional;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
public class FoodImageService {

    @Autowired
    private FoodImageRepository foodImageRepository;
    
    @Autowired
    private FoodRepository foodRepository;

    private static final String UPLOAD_DIR = "E:\\Goafood\\";
    
    
    
    // Fetch all food images
    public List<FoodImage> getAllFoodImages() {
        return foodImageRepository.findAll();
    }
    


    public String saveFoodImage(Long foodId, MultipartFile file) throws IOException {
        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Validate hotel existence
        Food food = foodRepository.findById(foodId)
                .orElseThrow(() -> new IllegalArgumentException("Food not found with ID: " + foodId));

        
        
        
        
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename().trim().replaceAll("[^a-zA-Z0-9._-]", "_");
       // Path filePath = Paths.get(UPLOAD_DIR + fileName);
       // Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        Path filePath = Paths.get(UPLOAD_DIR + File.separator + fileName);
        
        // Save file to disk
        file.transferTo(filePath.toFile());
        
        FoodImage foodImage = new FoodImage();
        foodImage.setFood(food);
        foodImage.setImageUrl(fileName);
        foodImageRepository.save(foodImage);

        return fileName;
    }

    
    
   
    // Change to your food images directory

    public ResponseEntity<Resource> getImage(String fileName)  {
    	try {
    	        Path filePath = Paths.get(UPLOAD_DIR).resolve(fileName).normalize();
    
        Resource resource = new UrlResource(filePath.toUri());

        if (resource.exists()) {
            return ResponseEntity.ok()
            		.contentType(MediaType.IMAGE_JPEG)
                   .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }catch(MalformedURLException e) {
    	
    	 return ResponseEntity.status(500).body(null);
    }
        
    }
    
    
    public List<FoodImage> getFoodImagesByFoodId(Long foodId) {
        List<FoodImage> images =  foodImageRepository.findByFoodId(foodId);
        
        for (FoodImage image : images) {
            image.setImageUrl("http://localhost:8081/uploads/Goafood/" + image.getImageUrl());
        }
        return images;
    }

//    public Resource getImage(String fileName) throws IOException {
//        Path filePath = Paths.get(UPLOAD_DIR).resolve(fileName).normalize();
//        Resource resource = new UrlResource(filePath.toUri());
//        if (resource.exists() && resource.isReadable()) {
//            return resource;
//        } else {
//            throw new IOException("File not found: " + fileName);
//        }
//    }

    public void deleteFoodImage(Long id) {
        Optional<FoodImage> foodImageOptional = foodImageRepository.findById(id);
        foodImageOptional.ifPresent(foodImage -> {
            Path filePath = Paths.get(UPLOAD_DIR).resolve(foodImage.getImageUrl());
            try {
                Files.deleteIfExists(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            foodImageRepository.deleteById(id);
        });
    }
}
