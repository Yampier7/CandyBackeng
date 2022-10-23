package pe.upc.edu.upcprecandy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.upc.edu.upcprecandy.entities.Pay;
import pe.upc.edu.upcprecandy.entities.Product;
import pe.upc.edu.upcprecandy.repository.PayRepository;
import pe.upc.edu.upcprecandy.repository.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PayController {

    @Autowired
    private PayRepository payRepository;
    @GetMapping("/pays")
    public ResponseEntity<List<Pay>> getAllPay(){
        List<Pay> pays=payRepository.findAll();
        return new ResponseEntity<List<Pay>>(pays, HttpStatus.OK);
    }
}
