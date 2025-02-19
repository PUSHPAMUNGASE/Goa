package com.example.food.entity;



import jakarta.persistence.*;
@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; 

    @Column(nullable = false)
    private String location;

    @Column(nullable = false, unique = true)
    private String contact;

	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hotel(Long id, String name, String location, String contact) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.contact = contact;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", location=" + location + ", contact=" + contact + "]";
	}

    // Getters and Setters
    
    
    
}
