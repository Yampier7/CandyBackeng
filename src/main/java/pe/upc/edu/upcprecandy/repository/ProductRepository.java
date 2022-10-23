package pe.upc.edu.upcprecandy.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.edu.upcprecandy.entities.Product;

import java.util.List;
import java.util.PrimitiveIterator;

public interface ProductRepository
extends JpaRepository<Product, Long> {

    //listatodo
    List<Product> findAllById(Long id);
    //listar por categoria
    List<Product> findByCategoria(String categoria);
}

//entidad donde vas hacer la query
//findby <atributo>
//list<Product> findby <atributo>(Lonf postid)