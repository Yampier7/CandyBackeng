package pe.upc.edu.upcprecandy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pe.upc.edu.upcprecandy.entities.Pay;
import pe.upc.edu.upcprecandy.entities.Product;
import pe.upc.edu.upcprecandy.repository.PayRepository;
import pe.upc.edu.upcprecandy.repository.ProductRepository;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api")
public class PayController {

    @Autowired
    private PayRepository payRepository;
    @Transactional(readOnly = true)
    @GetMapping("/pays")
    public ResponseEntity<List<Pay>> getAllPay(){
        List<Pay> pays=payRepository.findAll();
        return new ResponseEntity<List<Pay>>(pays, HttpStatus.OK);
    }

    @PostMapping("/pays")
    public ResponseEntity<Pay> createPay(@RequestBody Pay pay){
        Pay newPay=payRepository.save(
                new Pay(pay.getDireccion(),pay.getNTarjeta(),pay.getFecha(),pay.getCid(),pay.getPostal()));
        return new ResponseEntity<Pay>(newPay,HttpStatus.CREATED);
    }
}
