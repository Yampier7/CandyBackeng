package pe.upc.edu.upcprecandy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.upc.edu.upcprecandy.entities.Product;
import pe.upc.edu.upcprecandy.entities.User;
import pe.upc.edu.upcprecandy.repository.UserRepository;

import java.util.List;

@RestController // anotacion
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllProducts(){
        List<User> users=userRepository.findAll();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
}
