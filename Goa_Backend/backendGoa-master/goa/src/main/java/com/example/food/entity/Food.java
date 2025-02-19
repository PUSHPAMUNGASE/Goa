package com.example.food.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

//@Entity
//@Table(name = "food")
//public class Food {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false)
//    private String name; // Dish name
//
//    @Column(nullable = false)
//    private Double price; 
//
//    @Column(nullable = false, length = 500)
//    private String description;
//
//
//    
//    @ManyToOne
//    @JoinColumn(name = "category_id", nullable = false)
//    @JsonIgnoreProperties("foods")
//    private Category category;
//
//    @OneToOne
//    @JoinColumn(name = "hotel_image_id", nullable = false)
//    @JsonIgnoreProperties("foods")
//    private HotelImage hotelImage;  
//    
//    
//
//    @OneToOne
//    @JoinColumn(name = "food_image_id", nullable = false)
//    @JsonIgnoreProperties("foods")
//    private FoodImage foodImage;    
//    
//    
//    @OneToOne
//    @JoinColumn(name = "hotel_id", nullable = false)
//    @JsonIgnoreProperties("foods")
//    private Hotel hotel;
//
//
//	public Food() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//
//	public Food(Long id, String name, Double price, String description, Category category, HotelImage hotelImage,
//			FoodImage foodImage, Hotel hotel) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.price = price;
//		this.description = description;
//		this.category = category;
//		this.hotelImage = hotelImage;
//		this.foodImage = foodImage;
//		this.hotel = hotel;
//	}
//
//
//	public Long getId() {
//		return id;
//	}
//
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//
//	public String getName() {
//		return name;
//	}
//
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//
//	public Double getPrice() {
//		return price;
//	}
//
//
//	public void setPrice(Double price) {
//		this.price = price;
//	}
//
//
//	public String getDescription() {
//		return description;
//	}
//
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//
//	public Category getCategory() {
//		return category;
//	}
//
//
//	public void setCategory(Category category) {
//		this.category = category;
//	}
//
//
//	public HotelImage getHotelImage() {
//		return hotelImage;
//	}
//
//
//	public void setHotelImage(HotelImage hotelImage) {
//		this.hotelImage = hotelImage;
//	}
//
//
//	public FoodImage getFoodImage() {
//		return foodImage;
//	}
//
//
//	public void setFoodImage(FoodImage foodImage) {
//		this.foodImage = foodImage;
//	}
//
//
//	public Hotel getHotel() {
//		return hotel;
//	}
//
//
//	public void setHotel(Hotel hotel) {
//		this.hotel = hotel;
//	}
//    
//
//
//
//    // Getters and Setters
//    
//    
//    
//}





import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; // Dish name

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false, length = 500)
    private String description;

    // Many foods belong to one category
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @JsonIgnoreProperties("foods")  // Prevents infinite recursion
    private Category category;

    // One food has one image (food image)
//    @OneToOne
//    @JoinColumn(name = "food_image_id", nullable = true)
//    @JsonIgnoreProperties("food") // Prevents recursive serialization
//    private FoodImage foodImage;

    // One food belongs to one hotel
    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    @JsonIgnoreProperties("foods") // Prevents infinite loop
    private Hotel hotel;

    public Food() {
        super();
    }

    public Food(Long id, String name, Double price, String description, Category category,
                FoodImage foodImage, Hotel hotel) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
      //  this.foodImage = foodImage;
        this.hotel = hotel;
    }

    // Getters and Setters
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

//    public FoodImage getFoodImage() {
//        return foodImage;
//    }
//
//    public void setFoodImage(FoodImage foodImage) {
//        this.foodImage = foodImage;
//    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}

