package pe.upc.edu.upcprecandy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.upc.edu.upcprecandy.entities.Shipping;

import java.util.List;

public interface ShippingRepository extends JpaRepository<Shipping, Long> {
    List<Shipping> findByDetailId(Long id);
}
