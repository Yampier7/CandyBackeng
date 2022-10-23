package pe.upc.edu.upcprecandy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.edu.upcprecandy.entities.Detail;

import java.util.List;

public interface DetailRepository extends JpaRepository<Detail,Long> {
    List<Detail> findAllById(Long id);
}
