/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifnti.l3.jee.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ifnti.l3.jee.entities.Role;
import ifnti.l3.jee.entities.User;
import ifnti.l3.jee.repository.RoleRepository;
import ifnti.l3.jee.repository.UserRepository;

/**
 *
 * @author hafiz
 */

@Service
public class UserService {
    private UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public void clientInscription(User user){
        Optional<User> u =  userRepository.findByUsername(user.getUsername());
        if (u.isPresent()) {
            throw new RuntimeException("UserName deja utilisé");
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(user.getPwd());
        user.setPwd(hashedPassword);
        userRepository.save(user);
    }

    public void adminInscription(User user, List<Long> roleIds){
        Optional<User> u =  userRepository.findByUsername(user.getUsername());
        if (u.isPresent()) {
            throw new RuntimeException("UserName deja utilisé");
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(user.getPwd());
        user.setPwd(hashedPassword);
        Set<Role> userRoles = roleIds.stream()
                .map(roleId -> roleRepository.findById(roleId))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());

        user.setRoles(userRoles);
        userRepository.save(user);


    }
    
}
