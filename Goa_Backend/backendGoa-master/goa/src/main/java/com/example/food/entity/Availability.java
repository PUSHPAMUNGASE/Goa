package com.example.food.entity;



import jakarta.persistence.*;
@Entity
@Table(name = "availability")



public class Availability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "food_id", nullable = false)
    private Food food;

    @Column(nullable = false)
    private String isAvailable; // true if available, false otherwise

	public Availability() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Availability(Long id, Hotel hotel, Food food, String isAvailable) {
		super();
		this.id = id;
		this.hotel = hotel;
		this.food = food;
		this.isAvailable = isAvailable;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public String getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "Availability [id=" + id + ", hotel=" + hotel + ", food=" + food + ", isAvailable=" + isAvailable + "]";
	}

    // Getters and Setters
    
    
}
