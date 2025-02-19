////package com.example.food.service;
////
////
////
////import com.example.food.entity.*;
////import com.example.food.repository.HotelImageRepository;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Service;
////
////import java.util.List;
////
////@Service
////public class HotelImageService {
////
////    @Autowired
////    private HotelImageRepository hotelImageRepository;
////
////    public HotelImage saveHotelImage(HotelImage hotelImage) {
////        return hotelImageRepository.save(hotelImage);
////    }
////
////    public List<HotelImage> getHotelImagesByHotelId(Long hotelId) {
////        return hotelImageRepository.findByHotelId(hotelId);
////    }
////
////    public void deleteHotelImage(Long id) {
////        hotelImageRepository.deleteById(id);
////    }
////}
//
//
//
//package com.example.food.service;
//
//import com.example.food.entity.Hotel;
//import com.example.food.entity.HotelImage;
//import com.example.food.repository.HotelImageRepository;
//import com.example.food.repository.HotelRepository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.*;
//import java.util.List;
//
//
//
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.UrlResource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//
//
//
//@Service
//public class HotelImageService {
//
//    @Autowired
//    private HotelImageRepository hotelImageRepository;
//
//    @Autowired
//    private HotelRepository hotelRepository;
//
//    private static final String UPLOAD_DIR = "E:\\Hotels\\";
//
////    
////    public List<HotelImage> getAllHotelImages() {
////        return hotelImageRepository.findAll(); // Fetch all hotel images from the database
////    }
//
//    
//    public String saveHotelImage(Long hotelId, MultipartFile file) throws IOException {
//        // Ensure the upload directory exists
//        Path uploadPath = Paths.get(UPLOAD_DIR);
//        if (!Files.exists(uploadPath)) {
//            Files.createDirectories(uploadPath);
//        }
//
//        // Validate hotel existence
//        Hotel hotel = hotelRepository.findById(hotelId)
//                .orElseThrow(() -> new IllegalArgumentException("Hotel not found with ID: " + hotelId));
//
//        // Sanitize file name
//        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename().replaceAll("[^a-zA-Z0-9._-]", "_");
//        Path filePath = Paths.get(UPLOAD_DIR + File.separator + fileName);
//
//        // Save file to disk
//        file.transferTo(filePath.toFile());
//
//        // Save image details in the database
//        HotelImage hotelImage = new HotelImage();
//        hotelImage.setHotel(hotel);
//        hotelImage.setImageUrl(fileName); // Store only file name
//
//        hotelImageRepository.save(hotelImage);
//
//        return fileName;
//    }
//
//    public List<HotelImage> getHotelImagesByHotelId(Long hotelId) {
//        List<HotelImage> images = hotelImageRepository.findByHotelId(hotelId);
//        for (HotelImage image : images) {
//            image.setImageUrl("http://localhost:8085/uploads/hotels/" + image.getImageUrl());
//        }
//        return images;
//    }
//
//   
//
//    public ResponseEntity<Resource> getImage(String fileName) {
//        try {
//            Path filePath = Paths.get(UPLOAD_DIR).resolve(fileName).normalize();
//            Resource resource = new UrlResource(filePath.toUri());
//
//            if (resource.exists()) {
//                return ResponseEntity.ok()
//                        .contentType(MediaType.IMAGE_JPEG) // Change based on image type
//                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
//                        .body(resource);
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//        } catch (MalformedURLException e) {
//            return ResponseEntity.status(500).body(null);
//        }
//    }
//   
//    
//    public List<HotelImage> getAllHotelImages() {
//        return hotelImageRepository.findAll();
//    }
//    
//    public void deleteHotelImage(Long id) {
//        hotelImageRepository.deleteById(id);
//    }
//}
//





package com.example.food.service;

import com.example.food.entity.Hotel;
import com.example.food.entity.HotelImage;
import com.example.food.repository.HotelImageRepository;
import com.example.food.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.*;
import java.util.List;
import java.util.Optional;

@Service
public class HotelImageService {

    @Autowired
    private HotelImageRepository hotelImageRepository;

    @Autowired
    private HotelRepository hotelRepository;

    private static final String UPLOAD_DIR = "E:\\Hotels\\";

//    // Save Image to Disk & Database
//    public String saveHotelImage(Long hotelId, MultipartFile file) throws IOException {
//        Path uploadPath = Paths.get(UPLOAD_DIR);
//        if (!Files.exists(uploadPath)) {
//            Files.createDirectories(uploadPath);
//        }
//
//        
//        // Step 2: Check if an image already exists
////        <HotelImage> existingImageOpt = hotelImageRepository.findByHotelId(hotelId);
////        if (existingImageOpt.isPresent()) {
////            throw new RuntimeException("Image already exists for Hotel ID " + hotelId + ". Use update API instead.");
////        }
//
//        Hotel hotel = hotelRepository.findById(hotelId)
//                .orElseThrow(() -> new IllegalArgumentException("Hotel not found with ID: " + hotelId));
//
//        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename().replaceAll("[^a-zA-Z0-9._-]", "_");
//        Path filePath = Paths.get(UPLOAD_DIR + File.separator + fileName);
//        file.transferTo(filePath.toFile());
//
//        HotelImage hotelImage = new HotelImage();
//        hotelImage.setHotel(hotel);
//        hotelImage.setImageUrl(fileName); // Store filename only
//        hotelImageRepository.save(hotelImage);
//
//        return fileName;
//    }
//    
//    
//    
    
 
    
    public String saveHotelImage(Long hotelId, MultipartFile file) throws IOException {
        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Check if an image already exists for the hotel
        List<HotelImage> existingImages = hotelImageRepository.findByHotelId(hotelId);
        if (!existingImages.isEmpty()) {
            return "Hotel image with ID " + hotelId + " already exists. Please update instead.";
        }

        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new IllegalArgumentException("Hotel not found with ID: " + hotelId));

        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename().replaceAll("[^a-zA-Z0-9._-]", "_");
        Path filePath = Paths.get(UPLOAD_DIR + File.separator + fileName);
        file.transferTo(filePath.toFile());

        HotelImage hotelImage = new HotelImage();
        hotelImage.setHotel(hotel);
        hotelImage.setImageUrl(fileName); // Store filename only
        hotelImageRepository.save(hotelImage);

        return "Image uploaded successfully: " + fileName;
    }

    
    

    // Get Images for a Specific Hotel
    public List<HotelImage> getHotelImagesByHotelId(Long hotelId) {
        List<HotelImage> images = hotelImageRepository.findByHotelId(hotelId);
        for (HotelImage image : images) {
            image.setImageUrl("http://localhost:8081/hotel-images/view/" + image.getImageUrl());
        }
        return images;
    }

    // Serve Image File
    public ResponseEntity<Resource> getImage(String fileName) {
        try {
            Path filePath = Paths.get(UPLOAD_DIR).resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_JPEG) // Adjust if needed
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (MalformedURLException e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    // Get All Hotel Images
    public List<HotelImage> getAllHotelImages() {
        return hotelImageRepository.findAll();
    }

    // Delete Image
    public void deleteHotelImage(Long id) {
        hotelImageRepository.deleteById(id);
    }
}
