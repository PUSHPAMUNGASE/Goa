package  com.example.GoaFestival.Repository;


import  com.example.GoaFestival.Entity.Festival;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FestivalRepository extends JpaRepository<Festival, Long> {
    @Query("SELECT DISTINCT f FROM Festival f LEFT JOIN FETCH f.month m " +
            "LEFT JOIN FETCH f.festivalDetail LEFT JOIN FETCH f.comments " +
            "WHERE m.name = :monthName")
    List<Festival> findByMonthName(String monthName);
}