package pe.upc.edu.upcprecandy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.edu.upcprecandy.entities.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long id);
}
