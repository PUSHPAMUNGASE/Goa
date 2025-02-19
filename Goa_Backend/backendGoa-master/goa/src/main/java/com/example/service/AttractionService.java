//package com.example.service;
//
//import com.example.entity.Attractions;
//import com.example.repository.AttractionRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.UrlResource;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.nio.file.*;
//import java.util.List;
//
//@Service
//public class AttractionService {
//
//    @Autowired
//    private AttractionRepository attractionRepository;
//
//    @Value("${file.upload.path}")
//    private String uploadPath;
//
//    public Attractions saveAttraction(String name, MultipartFile file) throws IOException {
//        Path uploadDir = Paths.get(uploadPath);
//        if (!Files.exists(uploadDir)) {
//            Files.createDirectories(uploadDir);
//        }
//
//        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename().trim().replaceAll("[^a-zA-Z0-9._-]", "_");
//        Path filePath = uploadDir.resolve(fileName);
//        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
//
//        Attractions attraction = new Attractions(name, fileName);
//        return attractionRepository.save(attraction);
//    }
//
//    public Resource loadImage(String fileName) throws MalformedURLException {
//        Path filePath = Paths.get(uploadPath).resolve(fileName).normalize();
//        Resource resource = new UrlResource(filePath.toUri());
//        if (resource.exists()) {
//            return resource;
//        } else {
//            throw new MalformedURLException("File not found: " + fileName);
//        }
//    }
//
//    public List<Attractions> getAllAttractions() {
//        List<Attractions> attractions = attractionRepository.findAll();
//        for (Attractions attraction : attractions) {
//            String imageUrl = "/attractions/view/" + attraction.getImageUrl();
//            attraction.setImageUrl(imageUrl);
//        }
//        return attractions;
//    }
//
//    public void deleteAttraction(Long id) throws IOException {
//        Attractions attraction = attractionRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Attraction not found with ID: " + id));
//        Path filePath = Paths.get(uploadPath).resolve(attraction.getImageUrl());
//        Files.deleteIfExists(filePath);
//        attractionRepository.deleteById(id);
//    }
//}
