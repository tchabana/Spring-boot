/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ifnti.l3.jee.repository;

import java.util.Optional;

import ifnti.l3.jee.entities.User;

/**
 *
 * @author hafizh
 */
public interface UserRepository extends  org.springframework.data.repository.CrudRepository<User, Long>{
    Optional<User> findByUsername(String username);
}
