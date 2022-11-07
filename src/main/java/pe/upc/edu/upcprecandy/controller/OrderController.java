package pe.upc.edu.upcprecandy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.upc.edu.upcprecandy.entities.Order;
import pe.upc.edu.upcprecandy.exception.ResourceNotFoundException;
import pe.upc.edu.upcprecandy.repository.OrderRepository;
import pe.upc.edu.upcprecandy.repository.UserRepository;

import java.util.List;
;

@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Transactional(readOnly = true)
    @GetMapping("/users/{userId}/orders")
    public ResponseEntity<List<Order>> getOrderbyUser(@PathVariable("userId") Long userId){
        if(userRepository.existsById(userId)){
            throw new ResourceNotFoundException("No User con id="+userId);
        }
        List<Order> orders=orderRepository.findByUserId(userId);
        return new ResponseEntity<>(orders,HttpStatus.OK);
    }

}
