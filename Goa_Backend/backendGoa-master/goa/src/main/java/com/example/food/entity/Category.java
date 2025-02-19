package com.example.food.entity;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

	@Entity
	@Table(name = "category")
	public class Category {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false, unique = true)
	    private String name; // e.g., "Veg", "Non-Veg", "Seafood", "Goa Special"
	    
	    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	    @JsonBackReference
	    private List<Food> foods;

		public Category() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Category(Long id, String name) {
			super();
			this.id = id;
			this.name = name;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Category [id=" + id + ", name=" + name + "]";
		}

	    // Getters and Setters
	    
	    
	    
	}


