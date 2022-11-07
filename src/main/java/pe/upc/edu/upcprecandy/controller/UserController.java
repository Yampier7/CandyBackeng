package pe.upc.edu.upcprecandy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pe.upc.edu.upcprecandy.entities.Product;
import pe.upc.edu.upcprecandy.entities.User;
import pe.upc.edu.upcprecandy.exception.ResourceNotFoundException;
import pe.upc.edu.upcprecandy.repository.UserRepository;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController // anotacion
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Transactional(readOnly = true)
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllProducts(){
        List<User> users=userRepository.findAll();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User newUser=userRepository.save(
                new User(user.getTitle(), user.getApellido(),user.getCorreo(),user.getContrasenia()));
        return new ResponseEntity<User>(newUser,HttpStatus.CREATED);
    }

    /*@GetMapping("/users/{id}")
    public ResponseEntity<User> getUserId(@PathVariable("id")Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("no existe usuario con esta id=" + id));
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }*/

    @GetMapping("/users/{id}")
    public ResponseEntity<List<User>> getUserId(@PathVariable("id")Long id){
        if(!userRepository.existsById(id)){
            throw new ResourceNotFoundException("no existe usuario con esta id:"+id);
        }
        List<User> users=userRepository.findByUserJPQL(id);

        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable("id")Long id,
                                               @RequestBody User user){
        User userup=userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("no existe usuario con esta id:"+id));
        userup.setTitle(user.getTitle());
        userup.setApellido(user.getApellido());
        userup.setContrasenia(user.getContrasenia());
        return new ResponseEntity<User>(userRepository.save(userup), HttpStatus.OK);
    }
}
