package pe.upc.edu.upcprecandy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.upc.edu.upcprecandy.entities.Shipping;
import pe.upc.edu.upcprecandy.exception.ResourceNotFoundException;
import pe.upc.edu.upcprecandy.repository.DetailRepository;
import pe.upc.edu.upcprecandy.repository.ShippingRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ShippingController {
    @Autowired
    private DetailRepository detailRepository;
    @Autowired
    private ShippingRepository shippingRepository;

    @GetMapping("/details/{detailId}/shippings")
    public ResponseEntity<List<Shipping>> getShippingsBydetail(@PathVariable("detailId") Long detailId){
        if(detailRepository.existsById(detailId)){
            throw new ResourceNotFoundException("No User con id="+detailId);
        }
        List<Shipping> shippings=shippingRepository.findByDetailId(detailId);
        return new ResponseEntity<>(shippings,HttpStatus.OK);
    }
}
