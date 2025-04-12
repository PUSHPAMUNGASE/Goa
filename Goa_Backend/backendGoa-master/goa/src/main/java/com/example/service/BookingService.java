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
  
    @Service
    public class BookingService {
        @Autowired
        private BookingRepository bookingRepository;
   
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


            System.out.println("Payment Saved with Booking ID: " + savedBooking.getId());

            //Booking savedBooking = bookingRepository.save(booking);

            return savedBooking;
        }

        
        private double calculateTotalAmount(String packageName, int numberOfPeople) {
            return 5000 * numberOfPeople; // Example calculation
            
            
        }
    }
