package  com.example.GoaFestival.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "months")
@Data
public class Month {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "month")
    @JsonIgnore
    private List<Festival> festivals;

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

    public List<Festival> getFestivals() {
        return festivals;
    }

    public void setFestivals(List<Festival> festivals) {
        this.festivals = festivals;
    }

	public Month() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Month(Long id, String name, List<Festival> festivals) {
		super();
		this.id = id;
		this.name = name;
		this.festivals = festivals;
	}
    
    
	public Month(String name) {
	    this.name = name;
	}

    
}
