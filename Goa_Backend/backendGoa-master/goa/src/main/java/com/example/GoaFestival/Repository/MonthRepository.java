package  com.example.GoaFestival.Repository;

import  com.example.GoaFestival.Entity.Month;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonthRepository extends JpaRepository<Month, Long> {
    Month findByName(String name);
}