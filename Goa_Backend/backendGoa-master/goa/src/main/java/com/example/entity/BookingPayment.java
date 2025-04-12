package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "payments")
public class BookingPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String paymentStatus;
    private double totalAmount;
    
    
    
//    @OneToOne
//    @JoinColumn(name = "booking_id", unique = true, nullable = false)
//    private Booking booking;
   

	public BookingPayment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingPayment(Long id, String paymentStatus, double totalAmount) {
		super();
		this.id = id;
		this.paymentStatus = paymentStatus;
		this.totalAmount = totalAmount;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

    
    // Getters and Setters
    
    
    
}
