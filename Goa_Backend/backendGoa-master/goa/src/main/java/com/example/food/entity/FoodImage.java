package com.example.food.entity;


import jakarta.persistence.*;
@Entity
@Table(name = "food_images")
public class FoodImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "food_id", nullable = false)
    private Food food;

    @Column(nullable = false)
    private String imageUrl;

	public FoodImage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FoodImage(Long id, Food food, String imageUrl) {
		super();
		this.id = id;
		this.food = food;
		this.imageUrl = imageUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "FoodImage [id=" + id + ", food=" + food + ", imageUrl=" + imageUrl + "]";
	}

    // Getters and Setters
    
    
    
}

