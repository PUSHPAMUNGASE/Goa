//package com.example.food.controller;
//
//import com.example.food.entity.FoodImage;
//import com.example.food.service.FoodImageService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/food-images")
//public class FoodImageController {
//
//    @Autowired
//    private FoodImageService foodImageService;
//
//    @PostMapping("/add")
//    public ResponseEntity<FoodImage> addFoodImage(@RequestBody FoodImage foodImage) {
//        return ResponseEntity.ok(foodImageService.saveFoodImage(foodImage));
//    }
//
//    @GetMapping("/food/{foodId}")
//    public ResponseEntity<List<FoodImage>> getFoodImagesByFoodId(@PathVariable Long foodId) {
//        return ResponseEntity.ok(foodImageService.getFoodImagesByFoodId(foodId));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteFoodImage(@PathVariable Long id) {
//        foodImageService.deleteFoodImage(id);
//        return ResponseEntity.ok("Food Image deleted successfully");
//    }
//}



package com.example.food.controller;

import com.example.food.entity.FoodImage;
import com.example.food.service.FoodImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;


//http://localhost:8081/food-images/upload/1
@RestController
@RequestMapping("/food-images")
//@CrossOrigin(origins = "*") // Adjust as needed for frontend
public class FoodImageController {

    @Autowired
    private FoodImageService foodImageService;

    //@PostMapping("upload/{foodId}")
    @PostMapping(value = "/upload/{foodId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadFoodImage(@PathVariable Long foodId,
                                                  @RequestParam("file") MultipartFile file) {
        try {
            String fileName = foodImageService.saveFoodImage(foodId, file);
            return ResponseEntity.ok("Image uploaded successfully: " + fileName);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading image");
        }
    }

//    
//    @GetMapping("/all")
//    public ResponseEntity<List<FoodImage>> getAllFoodImages() {
//        List<FoodImage> foodImages = foodImageService.getAllFoodImages();
//        return ResponseEntity.ok(foodImages);
//    }
    
    
    
    // Get all Food Images with dynamically generated URLs
    @GetMapping("/all")
    public ResponseEntity<List<FoodImage>> getAllFoodImages() {
        List<FoodImage> foodImages = foodImageService.getAllFoodImages();

        for (FoodImage image : foodImages) {
            String imageUrl = "http://localhost:8081/food-images/view/" + image.getImageUrl();
            image.setImageUrl(imageUrl); // Update the image URL dynamically
        }

        return ResponseEntity.ok(foodImages);
    }
    
    
    @GetMapping("/{foodId}")
    public ResponseEntity<List<FoodImage>> getFoodImages(@PathVariable Long foodId) {
        return ResponseEntity.ok(foodImageService.getFoodImagesByFoodId(foodId));
    }
    
    
    //http://localhost:8081/food-images/view/1739051016049_k2.jpeg
    @GetMapping("/view/{fileName}")
    public ResponseEntity<Resource> getImage(@PathVariable String fileName) {
   
            return foodImageService.getImage(fileName);
       
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFoodImage(@PathVariable Long id) {
        foodImageService.deleteFoodImage(id);
        return ResponseEntity.ok("Food Image deleted successfully");
    }
}
