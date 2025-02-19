package com.example.dto;

import java.util.Date;
import java.util.List;

import com.example.entity.Person;

public class BookingRequest {
    private String fullName;
    private String email;
    private String phoneNumber;
    private Date checkInDate;
    private Date checkOutDate;
    private int numberOfPeople;
    private String packageName;
    private List<Person> persons;
	public BookingRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookingRequest(String fullName, String email, String phoneNumber, Date checkInDate, Date checkOutDate,
			int numberOfPeople, String packageName, List<Person> persons) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.numberOfPeople = numberOfPeople;
		this.packageName = packageName;
		this.persons = persons;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}
	public Date getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public int getNumberOfPeople() {
		return numberOfPeople;
	}
	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	@Override
	public String toString() {
		return "BookingRequest [fullName=" + fullName + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + ", numberOfPeople="
				+ numberOfPeople + ", packageName=" + packageName + ", persons=" + persons + "]";
	}
    
    // Getters and Setters
    
    
}