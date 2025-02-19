////package com.example.controller;
////
////import com.example.dto.BookingRequest;
////import com.example.entity.Booking;
////import com.example.service.BookingService;
////import com.itextpdf.text.Document;
////import com.itextpdf.text.DocumentException;
////import com.itextpdf.text.Paragraph;
////import com.itextpdf.text.pdf.PdfWriter;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.http.HttpHeaders;
////import org.springframework.http.HttpStatus;
////import org.springframework.http.MediaType;
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.*;
////
////import java.io.ByteArrayOutputStream;
////import java.util.List;
////import java.util.Map;
////
////@RestController
////@RequestMapping("/bookings")
////@CrossOrigin("*")
////public class BookingController {
////
////    @Autowired
////    private BookingService bookingService;
////
////    // Get all bookings
////    @GetMapping
////    public List<Booking> getAllBookings() {
////        return bookingService.getAllBookings();
////    }
////
////    // Get booking by ID
////    @GetMapping("/{id}")
////    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
////        Booking booking = bookingService.getBookingById(id);
////        return ResponseEntity.ok(booking);
////    }
////
////    // Create a new booking
////    @PostMapping
////    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
////        Booking savedBooking = bookingService.createOrUpdateBooking(booking);
////        return ResponseEntity.status(HttpStatus.CREATED).body(savedBooking);
////    }
////
////    // Delete a booking
////    @DeleteMapping("/{id}")
////    public ResponseEntity<String> deleteBooking(@PathVariable Long id) {
////        bookingService.deleteBooking(id);
////        return ResponseEntity.ok("Your booking has been canceled successfully.");
////    }
////
////    // Calculate total amount
////    @PostMapping("/calculateAmount")
////    public ResponseEntity<Map<String, Object>> calculateAmount(@RequestBody BookingRequest bookingRequest) {
////        int totalAmount = bookingService.calculateTotalAmount(bookingRequest.getPackageName(), bookingRequest.getNumberOfPeople());
////        return ResponseEntity.ok(Map.of("totalAmount", totalAmount));
////    }
////
////    // Confirm booking and generate PDF
////    @PostMapping("/confirmBooking")
////    public ResponseEntity<byte[]> confirmBooking(@RequestBody BookingRequest bookingRequest) {
////        int totalAmount = bookingService.calculateTotalAmount(bookingRequest.getPackageName(), bookingRequest.getNumberOfPeople());
////
////        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
////        try {
////            Document document = new Document();
////            PdfWriter.getInstance(document, outputStream);
////            document.open();
////            document.add(new Paragraph("Booking Confirmation"));
////            document.add(new Paragraph("Name: " + bookingRequest.getName()));
////            document.add(new Paragraph("Email: " + bookingRequest.getEmail()));
////            document.add(new Paragraph("Phone: " + bookingRequest.getPhone()));
////            document.add(new Paragraph("Package: " + bookingRequest.getPackageName()));
////            document.add(new Paragraph("Total Amount: ₹" + totalAmount));
////            document.close();
////        } catch (DocumentException e) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
////        }
////
////        return ResponseEntity.ok()
////                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=booking_confirmation.pdf")
////                .contentType(MediaType.APPLICATION_PDF)
////                .body(outputStream.toByteArray());
////    }
////}
//
//
//
//package com.example.controller;
//
//import com.example.dto.BookingRequest;
//import com.example.entity.Booking;
//import com.example.service.BookingService;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfWriter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.io.ByteArrayOutputStream;
//import java.util.List;
//import java.util.Map;
//
////@RestController
////@RequestMapping("/bookings")
////@CrossOrigin("*")
////public class BookingController {
////
////    @Autowired
////    private BookingService bookingService;
////
////    // Get all bookings
////    @GetMapping
////    public ResponseEntity<List<Booking>> getAllBookings() {
////        return ResponseEntity.ok(bookingService.getAllBookings());
////    }
////
////    // Get booking by ID
////    @GetMapping("/{id}")
////    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
////        return ResponseEntity.ok(bookingService.getBookingById(id));
////    }
////
////    // Create a new booking
////    @PostMapping
////    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
////        return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.createOrUpdateBooking(booking));
////    }
////
////    // Delete a booking
////    @DeleteMapping("/{id}")
////    public ResponseEntity<String> deleteBooking(@PathVariable Long id) {
////        bookingService.deleteBooking(id);
////        return ResponseEntity.ok("Your booking has been canceled successfully.");
////    }
////
////    // Calculate total amount
////    @PostMapping("/calculateAmount")
////    public ResponseEntity<Map<String, Object>> calculateAmount(@RequestBody BookingRequest bookingRequest) {
////        int totalAmount = bookingService.calculateTotalAmount(bookingRequest.getPackageName(), bookingRequest.getNumberOfPeople());
////        return ResponseEntity.ok(Map.of("totalAmount", totalAmount));
////    }
////
////    // Confirm booking and generate PDF
////    @PostMapping("/confirmBooking")
////    public ResponseEntity<byte[]> confirmBooking(@RequestBody BookingRequest bookingRequest) {
////        int totalAmount = bookingService.calculateTotalAmount(bookingRequest.getPackageName(), bookingRequest.getNumberOfPeople());
////        
////        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
////        try {
////            Document document = new Document();
////            PdfWriter.getInstance(document, outputStream);
////            document.open();
////            document.add(new Paragraph("Booking Confirmation"));
////            document.add(new Paragraph("Name: " + bookingRequest.getFullName()));
////            document.add(new Paragraph("Email: " + bookingRequest.getEmail()));
////            document.add(new Paragraph("Phone: " + bookingRequest.getPhoneNumber()));
////            document.add(new Paragraph("Package: " + bookingRequest.getPackageName()));
////            document.add(new Paragraph("Total Amount: ₹" + totalAmount));
////            document.close();
////        } catch (DocumentException e) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
////        }
////
////        return ResponseEntity.ok()
////                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=booking_confirmation.pdf")
////                .contentType(MediaType.APPLICATION_PDF)
////                .body(outputStream.toByteArray());
////    }
////}
//
//
//
//
//@RestController
//@RequestMapping("/bookings")
//@CrossOrigin("*")
//public class BookingController {
//    @Autowired
//    private BookingService bookingService;
//
//    @PostMapping
//    public ResponseEntity<Booking> createBooking(@RequestBody BookingRequest request) {
//        Booking booking = bookingService.createBooking(request);
//        return ResponseEntity.status(HttpStatus.CREATED).body(booking);
//        
//      //  System.out.println("Booking ID: " + savedBooking.getId());
//       // System.out.println("Payment ID: " + payment.getId());
//    }
//    
//   
//
//}
