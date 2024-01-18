/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifnti.l3.jee.controllers.api;

import ifnti.l3.jee.entities.Role;
import ifnti.l3.jee.repository.RoleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hafizh
 */
@RestController
public class RoleRestController {
    private final RoleRepository roleRepository;

    public RoleRestController(RoleRepository employeeRepository) {
        this.roleRepository = employeeRepository;
    }
    
    @GetMapping("/api/roles")
    public Iterable<Role> findAllRoles() {
        return this.roleRepository.findAll();
    }

    @PostMapping("/api/createrole")
    public Role addOneRole(@RequestBody Role employee) {
        return this.roleRepository.save(employee);
    }
    
}
