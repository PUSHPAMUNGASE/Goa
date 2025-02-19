//package com.example.service;
//
//import com.example.entity.Booking;
//import com.example.repository.BookingRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Service
//@Transactional
//public class BookingService {
//
//    @Autowired
//    private BookingRepository bookingRepository;
//
//    private static final Map<String, Integer> PACKAGE_PRICES = new HashMap<>();
//
//    static {
//        PACKAGE_PRICES.put("Goa Group Tour", 7000);
//        PACKAGE_PRICES.put("Family Package Tour", 12000);
//        PACKAGE_PRICES.put("Hinterland Package Tour", 9000);
//        PACKAGE_PRICES.put("Party de Goa Tour Package", 15000);
//        PACKAGE_PRICES.put("North Goa Package", 8000);
//        PACKAGE_PRICES.put("South Goa Package", 8500);
//    }
//    
//    
//    
//
//    // Retrieve all bookings
//    public List<Booking> getAllBookings() {
//        return bookingRepository.findAll();
//    }
//
//    // Retrieve booking by ID
//    public Booking getBookingById(Long id) {
//        return bookingRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Booking not found with ID: " + id));
//    }
//
//    // Save or update a booking
//    public Booking createOrUpdateBooking(Booking booking) {
//        return bookingRepository.save(booking);
//    }
//
//    // Delete a booking by ID
//    public void deleteBooking(Long id) {
//        if (!bookingRepository.existsById(id)) {
//            throw new RuntimeException("Cannot delete. Booking not found with ID: " + id);
//        }
//        bookingRepository.deleteById(id);
//    }
//
//    // Calculate total amount based on package
//    public int calculateTotalAmount(String packageName, int numberOfPeople) {
//        Integer pricePerPerson = PACKAGE_PRICES.get(packageName);
//        if (pricePerPerson == null) {
//            throw new IllegalArgumentException("Invalid package name: " + packageName);
//        }
//        return pricePerPerson * numberOfPeople;
//    }
//}




package com.example.service;

import com.example.dto.BookingRequest;
import com.example.entity.Booking;
import com.example.entity.BookingPayment;
import com.example.entity.Person;
import com.example.repository.BookingPaymentRepository;
import com.example.repository.BookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Service
//@Transactional
//public class BookingService {
//
//    @Autowired
//    private BookingRepository bookingRepository;
//
//    @Autowired
//    private BookingPaymentRepository paymentRepository;
//
//    private static final Map<String, Integer> PACKAGE_PRICES = new HashMap<>();
//
//    static {
//        PACKAGE_PRICES.put("Goa Group Tour", 7000);
//        PACKAGE_PRICES.put("Family Package Tour", 12000);
//        PACKAGE_PRICES.put("Hinterland Package Tour", 9000);
//        PACKAGE_PRICES.put("Party de Goa Tour Package", 15000);
//        PACKAGE_PRICES.put("North Goa Package", 8000);
//        PACKAGE_PRICES.put("South Goa Package", 8500);
//    }
//
//    // Retrieve all bookings
//    public List<Booking> getAllBookings() {
//        return bookingRepository.findAll();
//    }
//
//    // Retrieve booking by ID
//    public Booking getBookingById(Long id) {
//        return bookingRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Booking not found with ID: " + id));
//    }
//
//    // Save or update a booking and automatically update payment table
//    public Booking createOrUpdateBooking(Booking booking) {
//        Booking savedBooking = bookingRepository.save(booking);
//
//        // Calculate total amount
//        int totalAmount = calculateTotalAmount(booking.getPackageName(), booking.getNumberOfPeople());
//
//        // Save to payment table
//        BookingPayment payment = new BookingPayment();
//        payment.setBooking(savedBooking);  // Pass the entire Booking object
//        payment.setTotalAmount(totalAmount);
//        payment.setPaymentStatus("Pending");  // Changed from setStatus to setPaymentStatus
//        paymentRepository.save(payment);
//
//        return savedBooking;
//    }


//    public Booking createOrUpdateBooking(Booking booking) {
//        Booking savedBooking = bookingRepository.save(booking);
//        System.out.println("Booking saved: " + savedBooking.getId());
//
//        try {
//            int totalAmount = calculateTotalAmount(booking.getPackageName(), booking.getNumberOfPeople());
//            System.out.println("Total amount calculated: " + totalAmount);
//
//            BookingPayment payment = new BookingPayment();
//            payment.setBooking(savedBooking);
//            payment.setTotalAmount(totalAmount);
//            payment.setPaymentStatus("Pending");
//
//            BookingPayment savedPayment = paymentRepository.save(payment);
//            System.out.println("Payment saved: " + savedPayment.getId());
//
//        } catch (Exception e) {
//            System.out.println("Error saving payment: " + e.getMessage());
//        }
//
//        return savedBooking;
//    }
//
//    
//    
//    
//    // Delete a booking by ID
//    public void deleteBooking(Long id) {
//        if (!bookingRepository.existsById(id)) {
//            throw new RuntimeException("Cannot delete. Booking not found with ID: " + id);
//        }
//        bookingRepository.deleteById(id);
//    }
//
//    // Calculate total amount based on package
//    public int calculateTotalAmount(String packageName, int numberOfPeople) {
//        Integer pricePerPerson = PACKAGE_PRICES.get(packageName);
//        if (pricePerPerson == null) {
//            throw new IllegalArgumentException("Invalid package name: " + packageName);
//        }
//        return pricePerPerson * numberOfPeople;
//    }
//}
//

    
    
    
    
    @Service
    public class BookingService {
        @Autowired
        private BookingRepository bookingRepository;
        
//        public Booking createBooking(BookingRequest request) {
//            Booking booking = new Booking();
//            booking.setFullName(request.getFullName());
//            booking.setEmail(request.getEmail());
//            booking.setPhoneNumber(request.getPhoneNumber());
//            booking.setCheckInDate(request.getCheckInDate());
//            booking.setCheckOutDate(request.getCheckOutDate());
//            booking.setNumberOfPeople(request.getNumberOfPeople());
//            booking.setPackageName(request.getPackageName());
//            
//            List<Person> persons = request.getPersons();
//            persons.forEach(person -> person.setBooking(booking));
//            booking.setPersons(persons);
//            
//            Booking savedBooking = bookingRepository.save(booking);
//            
//            BookingPayment payment = new BookingPayment();
//            payment.setBooking(savedBooking);
//            payment.setPaymentStatus("Pending");
//            payment.setTotalAmount(calculateTotalAmount(request.getPackageName(), request.getNumberOfPeople()));
//            paymentRepository.save(payment);
//            
//            return savedBooking;
//        }
//        
//        
        
        
        @Autowired
        private BookingPaymentRepository paymentRepository;

        
        @Transactional
        public Booking createBooking(BookingRequest request) {
            Booking booking = new Booking();
            booking.setFullName(request.getFullName());
            booking.setEmail(request.getEmail());
            booking.setPhoneNumber(request.getPhoneNumber());
            booking.setCheckInDate(request.getCheckInDate());
            booking.setCheckOutDate(request.getCheckOutDate());
            booking.setNumberOfPeople(request.getNumberOfPeople());
            booking.setPackageName(request.getPackageName());

            List<Person> persons = request.getPersons();
            persons.forEach(person -> person.setBooking(booking));
            booking.setPersons(persons);
            
            BookingPayment payment = new BookingPayment();
            
            payment.setPaymentStatus("Pending");
            payment.setTotalAmount(calculateTotalAmount(request.getPackageName(), request.getNumberOfPeople()));
            
            booking.setPayment(payment);

            Booking savedBooking = bookingRepository.save(booking);//payment object

            // Check if the booking is actually saved
            System.out.println("Saved Booking ID: " + savedBooking.getId());
//
//            BookingPayment payment = new BookingPayment();
//          
//            payment.setPaymentStatus("Pending");
//            payment.setTotalAmount(calculateTotalAmount(request.getPackageName(), request.getNumberOfPeople()));
//
//            System.out.println("Payment Details Before Save: " + payment.getTotalAmount());
//
//            paymentRepository.save(payment);

            System.out.println("Payment Saved with Booking ID: " + savedBooking.getId());

            //Booking savedBooking = bookingRepository.save(booking);

            return savedBooking;
        }

        
//        public Booking createBooking(Booking booking) {
//            Booking savedBooking = bookingRepository.save(booking);
//
//            // Create and attach payment
//            BookingPayment payment = new BookingPayment();
//            payment.setPaymentStatus("Pending"); // Or "Completed"
//            payment.setTotalAmount(10000.0);  // Set appropriate amount
//            payment.setBooking(savedBooking);
//
//            paymentRepository.save(payment);
//
//            return savedBooking;
//        }
    
   

        
        private double calculateTotalAmount(String packageName, int numberOfPeople) {
            return 5000 * numberOfPeople; // Example calculation
            
            
        }
    }