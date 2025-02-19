//package com.example.food.entity;
//
//
//
//import jakarta.persistence.*;
//@Entity
//@Table(name = "hotel_images")
//public class HotelImage {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "hotel_id", nullable = false)
//    private Hotel hotel;
//
//    @Column(nullable = false)
//    private String imageUrl;
//
//	public HotelImage() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public HotelImage(Long id, Hotel hotel, String imageUrl) {
//		super();
//		this.id = id;
//		this.hotel = hotel;
//		this.imageUrl = imageUrl;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public Hotel getHotel() {
//		return hotel;
//	}
//
//	public void setHotel(Hotel hotel) {
//		this.hotel = hotel;
//	}
//
//	public String getImageUrl() {
//		return imageUrl;
//	}
//
//	public void setImageUrl(String imageUrl) {
//		this.imageUrl = imageUrl;
//	}
//
//	@Override
//	public String toString() {
//		return "HotelImage [id=" + id + ", hotel=" + hotel + ", imageUrl=" + imageUrl + "]";
//	}
//
//    // Getters and Setters
//    
//    
//}



package com.example.food.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "hotel_images")
public class HotelImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    @Column(nullable = false)
    private String imageUrl;

    public HotelImage() {}

    public HotelImage(Long id, Hotel hotel, String imageUrl) {
        this.id = id;
        this.hotel = hotel;
        this.imageUrl = imageUrl;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "HotelImage [id=" + id + ", hotel=" + hotel + ", imageUrl=" + imageUrl + "]";
    }
}
