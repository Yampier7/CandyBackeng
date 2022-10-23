package pe.upc.edu.upcprecandy.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.edu.upcprecandy.entities.Product;
import pe.upc.edu.upcprecandy.repository.ProductRepository;

import java.util.List;


@RestController // anotacion
@RequestMapping("/api")
public class ProductController {
    //get posh-> registar put-> actualizar delete
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products=productRepository.findAll();
        return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
    }
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product newProduct=productRepository.save(
                new Product(product.getTitle(), product.getPais(),product.getPrecio(),product.getCategoria(),product.getUrl()));
        return new ResponseEntity<Product>(newProduct,HttpStatus.CREATED);
    }
    @GetMapping("/products/chocolate")
    public ResponseEntity<List<Product>> findProductByChocolate(){
        List<Product> products=productRepository.findByCategoria("chocolate");
        if (products.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @GetMapping("/products/galletas")

    public ResponseEntity<List<Product>> findProductByGalleta(){
        List<Product> products=productRepository.findByCategoria("galleta");
        if (products.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @GetMapping("/products/caramelos")
    public ResponseEntity<List<Product>> findProductByCaramelo(){
        List<Product> products=productRepository.findByCategoria("caramelos");
        if (products.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

}
