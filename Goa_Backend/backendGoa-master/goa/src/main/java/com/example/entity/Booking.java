//package com.example.entity;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.*;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//
//@Entity
//@Table(name = "bookings")
//public class Booking {
//    
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NotBlank(message = "Full Name is required")
//    private String fullName;
//
//    @Email(message = "Invalid email format")
//    private String email;
//
//    @Pattern(regexp = "^\\d{10}$", message = "Invalid phone number")
//    private String phoneNumber;
//
//    @Future(message = "Check-in date must be in the future")
//    private LocalDate checkInDate;
//
//    @Future(message = "Check-out date must be in the future")
//    private LocalDate checkOutDate;
//
//    @Min(value = 1, message = "At least 1 person required")
//    private int numberOfPeople;
//
//
//    
//  
//
//    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonManagedReference
//    private List<Person> persons = new ArrayList<>();
//    
//    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "booking_id")
//    private BookingPayment bookingPayment;
//
//
//
//
//
//    private String packageName;
//
//    // Default Constructor
//    public Booking() {}
//
//    // Parameterized Constructor
//    public Booking(Long id, String fullName, String email, String phoneNumber, LocalDate checkInDate, 
//                   LocalDate checkOutDate, int numberOfPeople, List<Person> persons, String packageName) {
//        this.id = id;
//        this.fullName = fullName;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
//        this.checkInDate = checkInDate;
//        this.checkOutDate = checkOutDate;
//        this.numberOfPeople = numberOfPeople;
//        this.packageName = packageName;
//        if (persons != null) {
//            this.persons = persons;
//            for (Person p : persons) {
//                p.setBooking(this);  // Maintain bidirectional reference
//            }
//        }
//    }
//
//    // Getters and Setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getFullName() {
//        return fullName;
//    }
//
//    public void setFullName(String fullName) {
//        this.fullName = fullName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public LocalDate getCheckInDate() {
//        return checkInDate;
//    }
//
//    public void setCheckInDate(LocalDate checkInDate) {
//        this.checkInDate = checkInDate;
//    }
//
//    public LocalDate getCheckOutDate() {
//        return checkOutDate;
//    }
//
//    public void setCheckOutDate(LocalDate checkOutDate) {
//        this.checkOutDate = checkOutDate;
//    }
//
//    public int getNumberOfPeople() {
//        return numberOfPeople;
//    }
//
//    public void setNumberOfPeople(int numberOfPeople) {
//        this.numberOfPeople = numberOfPeople;
//    }
//
//    public List<Person> getPersons() {
//        return persons;
//    }
//
//    public void setPersons(List<Person> persons) {
//        this.persons = persons;
//        for (Person p : persons) {
//            p.setBooking(this); // Maintain bidirectional relationship
//        }
//    }
//
//    public void addPerson(Person person) {
//        persons.add(person);
//        person.setBooking(this);
//    }
//
//    public void removePerson(Person person) {
//        persons.remove(person);
//        person.setBooking(null);
//    }
//
//    public String getPackageName() {
//        return packageName;
//    }
//
//    public void setPackageName(String packageName) {
//        this.packageName = packageName;
//    }
//    
//    
//
//    public BookingPayment getBookingPayment() {
//        return bookingPayment;
//    }
//
//    public void setBookingPayment(BookingPayment bookingPayment) {
//        this.bookingPayment = bookingPayment;
//    }
//
//    @Override
//    public String toString() {
//        return "Booking [id=" + id + ", fullName=" + fullName + ", email=" + email + ", phoneNumber=" + phoneNumber
//                + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + ", numberOfPeople="
//                + numberOfPeople + ", persons=" + persons + ", packageName=" + packageName + "]";
//    }
//}




package com.example.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;
    private String phoneNumber;
    private Date checkInDate;
    private Date checkOutDate;
    private int numberOfPeople;
    private String packageName;
    
    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Person> persons;

    //@OneToOne(mappedBy = "booking", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   
    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name="payment_id")
    private BookingPayment payment;

   

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(Long id, String fullName, String email, String phoneNumber, Date checkInDate, Date checkOutDate,
			int numberOfPeople, String packageName, List<Person> persons, BookingPayment payment) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.numberOfPeople = numberOfPeople;
		this.packageName = packageName;
		this.persons = persons;
		this.payment = payment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public BookingPayment getPayment() {
		return payment;
	}

	public void setPayment(BookingPayment payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", fullName=" + fullName + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + ", numberOfPeople="
				+ numberOfPeople + ", packageName=" + packageName + ", persons=" + persons + "]";
	}
    
    // Getters and Setters
    
    
    
}
