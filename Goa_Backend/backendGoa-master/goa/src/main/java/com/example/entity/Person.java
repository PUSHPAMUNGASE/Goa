
package com.example.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    
    @ManyToOne
    
    @JoinColumn(name = "booking_id", nullable = false)
    @JsonBackReference
    private Booking booking;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(Long id, String firstName, String lastName, int age, Booking booking) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.booking = booking;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
     
}
