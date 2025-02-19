package  com.example.GoaFestival.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "festival_details")
@Data
public class FestivalDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String type;

    @Column
    private String date;

    @Column(length = 2000)
    private String content;

    @Column(length = 2000)
    private String history;

    @Column(length = 1000)
    private String traditions;

    @Column(length = 500)
    private String location;

    @OneToOne(mappedBy = "festivalDetail")
    @JsonBackReference
    private Festival festival;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getTraditions() {
        return traditions;
    }

    public void setTraditions(String traditions) {
        this.traditions = traditions;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Festival getFestival() {
        return festival;
    }

    public void setFestival(Festival festival) {
        this.festival = festival;
    }
}
