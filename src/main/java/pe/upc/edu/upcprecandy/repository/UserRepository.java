package pe.upc.edu.upcprecandy.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.upc.edu.upcprecandy.entities.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.id=?1")
    List<User> findByUserJPQL(Long id);

}
