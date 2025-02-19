package  com.example.GoaFestival.Repository;

import  com.example.GoaFestival.Entity.FestivalDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FestivalDetailRepository extends JpaRepository<FestivalDetail, Long> {
}