package com.example.GoaFestival.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1000)
    private String content;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "festival_id", nullable = false)
    @JsonBackReference
    private Festival festival;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(Long id, String content, LocalDateTime createdAt, Festival festival) {
		super();
		this.id = id;
		this.content = content;
		this.createdAt = createdAt;
		this.festival = festival;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Festival getFestival() {
		return festival;
	}

	public void setFestival(Festival festival) {
		this.festival = festival;
	}
    
    
}