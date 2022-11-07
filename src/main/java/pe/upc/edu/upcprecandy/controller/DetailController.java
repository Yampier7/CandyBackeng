package pe.upc.edu.upcprecandy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pe.upc.edu.upcprecandy.entities.Detail;
import pe.upc.edu.upcprecandy.repository.DetailRepository;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api")
public class DetailController {
    @Autowired
    private DetailRepository detailRepository;

    @Transactional(readOnly = true)
    @GetMapping("/details")
    public ResponseEntity<List<Detail>> getAllDetail(){
        List<Detail> details=detailRepository.findAll();
        return new ResponseEntity<List<Detail>>(details, HttpStatus.OK);
    }
    @PostMapping("/details")
    public ResponseEntity<Detail> createDetail(@RequestBody Detail detail){
        Detail newDetail= detailRepository.save(
                new Detail(detail.getTitle(),detail.getPrecio(),detail.getUrl()
                        ,detail.getPais(),detail.getCategoria()));
        return new ResponseEntity<Detail>(newDetail,HttpStatus.CREATED);
    }

    @DeleteMapping("/details/{id}")
    public ResponseEntity<HttpStatus> deleteDetail(@PathVariable("id")Long id){
        detailRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
