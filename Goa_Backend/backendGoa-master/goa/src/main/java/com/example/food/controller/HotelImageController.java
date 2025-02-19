////package com.example.food.controller;
////
////import com.example.food.entity.HotelImage;
////import com.example.food.service.HotelImageService;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.*;
////import org.springframework.web.multipart.MultipartFile;
////import org.springframework.http.HttpStatus;
////
////import java.io.File;
////import java.io.IOException;
////import java.nio.file.*;
////import java.util.HashMap;
////import java.util.List;
////import java.util.Map;
////
////@RestController
////@RequestMapping("/hotel-images")
////@CrossOrigin(origins = "*")
////public class HotelImageController {
////
////    @Autowired
////    private HotelImageService hotelImageService;
////
////    private static final String UPLOAD_DIR = "D:\\FarmEcoUploads\\Hotels\\";
////
////    @PostMapping("/add")
////    public ResponseEntity<?> addHotelImage(@RequestParam Long hotelId, @RequestParam("file") MultipartFile file) {
////        Map<String, String> response = new HashMap<>();
////        
////        try {
////            Path path = Paths.get(UPLOAD_DIR);
////            if (!Files.exists(path)) {
////                Files.createDirectories(path);
////            }
////
////            // Sanitize file name
////            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename().trim().replaceAll("[^a-zA-Z0-9._-]", "_");
////            Path filePath = Paths.get(UPLOAD_DIR + File.separator + fileName);
////
////            file.transferTo(filePath.toFile());
////
////            HotelImage hotelImage = new HotelImage();
////            hotelImage.setImageUrl(fileName);
////            hotelImageService.saveHotelImage(hotelImage, hotelId);
////
////            response.put("message", "Image uploaded successfully: " + fileName);
////            return ResponseEntity.ok(response);
////        } catch (IOException e) {
////            e.printStackTrace();
////            response.put("message", "Error uploading image: " + e.getMessage());
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
////        }
////    }
////
////    @GetMapping("/hotel/{hotelId}")
////    public ResponseEntity<List<HotelImage>> getHotelImagesByHotelId(@PathVariable Long hotelId) {
////        List<HotelImage> hotelImages = hotelImageService.getHotelImagesByHotelId(hotelId);
////        
////        for (HotelImage image : hotelImages) {
////            String imageUrl = "http://localhost:8085/uploads/hotels/" + image.getImageUrl();
////            image.setImageUrl(imageUrl);
////        }
////
////        return ResponseEntity.ok(hotelImages);
////    }
////
////    @DeleteMapping("/{id}")
////    public ResponseEntity<String> deleteHotelImage(@PathVariable Long id) {
////        hotelImageService.deleteHotelImage(id);
////        return ResponseEntity.ok("Hotel Image deleted successfully");
////    }
////}
//
//
//
//package com.example.food.controller;
//
//import com.example.food.entity.HotelImage;
//import com.example.food.service.HotelImageService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.Resource;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//
//import java.io.IOException;
//
//
//import java.util.List;
////http://localhost:8081/hotel-images/upload/1
//@RestController
//@RequestMapping("/hotel-images")
//@CrossOrigin(origins = "*") // Adjust as needed for frontend
//public class HotelImageController {
//
//    @Autowired
//    private HotelImageService hotelImageService;
//
//    //@PostMapping("/upload/{hotelId}")
//    @PostMapping(value = "/upload/{hotelId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//
//    public ResponseEntity<String> uploadHotelImage(@PathVariable Long hotelId,
//                                                   @RequestParam("file") MultipartFile file) {
//        try {
//            String fileName = hotelImageService.saveHotelImage(hotelId, file);
//            return ResponseEntity.ok("Image uploaded successfully: " + fileName);
//        } catch (IOException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading image");
//        }
//    }
//
//    @GetMapping("/{hotelId}")
//    public ResponseEntity<List<HotelImage>> getHotelImages(@PathVariable Long hotelId) {
//        return ResponseEntity.ok(hotelImageService.getHotelImagesByHotelId(hotelId));
//    }
//
//    //http://localhost:8081/hotel-images/view/1739041469254_user.jpg
//    @GetMapping("/view/{fileName}")
//    public ResponseEntity<Resource> getImage(@PathVariable String fileName) {
//        return hotelImageService.getImage(fileName);
//    }
//
//    
//    
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<String> deleteHotelImage(@PathVariable Long id) {
//        hotelImageService.deleteHotelImage(id);
//        return ResponseEntity.ok("Image deleted successfully");
//    }
//    
//    
//    
//    
//    
//    
////    @GetMapping("/orders")
////    public ResponseEntity<?> getOrders() {
////        List<WasteDetails> wasteDetailsList = fileUploadService.getAllRequests();
////
////        if (wasteDetailsList.isEmpty()) {
////            return ResponseEntity.ok(Map.of("message", "No orders found "));
////        }
////
////        for (WasteDetails wasteDetails : wasteDetailsList) {
////            // Construct the image URL
////            String imageUrl = "http://localhost:8085/uploads/" + wasteDetails.getImagePath();
////            wasteDetails.setImagePath(imageUrl);  // Set the correct image URL
////        }
////
////        return ResponseEntity.ok(wasteDetailsList);
////    }
////    
//    @GetMapping("/all")
//    public ResponseEntity<?> getHotelImages(){
////    	List<HotelImage> hotelImageList=hotelImageService.getAllHotelImages();
//    	if(hotelImageList.isEmpty()) {
//    		return ResponseEntity.ok(Map.of("message","No orders found"));
//    	}
//    	
//    	for(HotelImage images:hotelImageList) {
//    		String imageUrl="http://localhost:8081/hotel-images/uploads/"+HotelImage.getImagePath();
//    		HotelImage.setImagePath(imageUrl)
//    	}
//    	
//    }
//    
//    @GetMapping("/all")
//    public ResponseEntity<List<HotelImage>> getAllHotelImages() {
//        List<HotelImage> hotelImages = hotelImageService.getAllHotelImages();
//        return ResponseEntity.ok(hotelImages);
//    }
//    
//}






package com.example.food.controller;

import com.example.food.entity.HotelImage;
import com.example.food.service.HotelImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/hotel-images")
@CrossOrigin(origins = "*") // Adjust as needed for frontend
public class HotelImageController {

    @Autowired
    private HotelImageService hotelImageService;

    // Upload Image API
    @PostMapping(value = "/upload/{hotelId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadHotelImage(@PathVariable Long hotelId, @RequestParam("file") MultipartFile file) {
        try {
            String fileName = hotelImageService.saveHotelImage(hotelId, file);
            return ResponseEntity.ok("Image uploaded successfully: " + fileName);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading image");
        }
    }

    // Get Images for a Specific Hotel
    @GetMapping("/{hotelId}")
    public ResponseEntity<List<HotelImage>> getHotelImages(@PathVariable Long hotelId) {
        return ResponseEntity.ok(hotelImageService.getHotelImagesByHotelId(hotelId));
    }

    // Serve Image File
    @GetMapping("/view/{fileName}")
    public ResponseEntity<Resource> getImage(@PathVariable String fileName) {
        return hotelImageService.getImage(fileName);
    }

    // Get All Hotel Images (FIXED)
    @GetMapping("/all")
    public ResponseEntity<List<HotelImage>> getAllHotelImages() {
        List<HotelImage> hotelImages = hotelImageService.getAllHotelImages();
        
        for (HotelImage image : hotelImages) {
            String imageUrl = "http://localhost:8081/hotel-images/view/" + image.getImageUrl();
            image.setImageUrl(imageUrl); // Update the image URL dynamically
        }
        
        return ResponseEntity.ok(hotelImages);
    }

    // Delete Image API
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteHotelImage(@PathVariable Long id) {
        hotelImageService.deleteHotelImage(id);
        return ResponseEntity.ok("Image deleted successfully");
    }
}
