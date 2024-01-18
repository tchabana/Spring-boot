/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifnti.l3.jee.controllers.api;

import ifnti.l3.jee.entities.User;
import ifnti.l3.jee.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hafizh
 */
@RestController
public class UserRestController {
    
    private final UserRepository userRepository;

    public UserRestController(UserRepository employeeRepository) {
        this.userRepository = employeeRepository;
    }
    
    @GetMapping("/api/users")
    public Iterable<User> findAllUsers() {
        return this.userRepository.findAll();
    }

    @PostMapping("/api/creatuser")
    public User addOneUser(@RequestBody User employee) {
        return this.userRepository.save(employee);
    }
    
}
