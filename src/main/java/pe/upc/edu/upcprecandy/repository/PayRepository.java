package pe.upc.edu.upcprecandy.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.upc.edu.upcprecandy.entities.Pay;

import java.util.List;


public interface PayRepository extends JpaRepository<Pay, Long> {

    @Query(value = "SELECT * from pays p inner join details d on p.id = d.id " +
            "inner join users u on d.id = u.detail_id WHERE u.id=?1", nativeQuery = true)
    List<Pay> findAllPayUserIdSQL(Long id);
}
