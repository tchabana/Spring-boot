/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifnti.l3.jee.controllers;

import ifnti.l3.jee.entities.Role;
import ifnti.l3.jee.entities.User;
import ifnti.l3.jee.repository.RoleRepository;
import ifnti.l3.jee.repository.UserRepository;
import ifnti.l3.jee.service.UserService;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


/**
 *
 * @author hafizh
 */

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    public final UserService userService;

    public UserController(UserRepository userRepository, RoleRepository roleRepository,UserService userService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userService = userService;
    }

    @GetMapping
    public String findAllUsers(Model model) {
        List<User> users = (List<User>) userRepository.findAll();
        model.addAttribute("users", users);
        return "pages/user/index";
    }

    @GetMapping("/create")
    public String addOneUser(Model model) {
        model.addAttribute("user", new User());
        List<Role> roles = (List<Role>) this.roleRepository.findAll();
        model.addAttribute("roles", roles);
        return "pages/user/create";
    }

    @PostMapping("/create")
    public String saveUser(@ModelAttribute User user, @RequestParam(name = "roles", required = false) List<Long> roleIds) {
        try {
            userService.adminInscription(user, roleIds);
        } catch (Exception e) {
            return "redirect:/register";
        }
        return "redirect:/users";
    }
    @PostMapping("/create-client")
    public String saveUserClient(@ModelAttribute User user) {
        userService.clientInscription(user);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            model.addAttribute("user", optionalUser.get());
            List<Role> roles = (List<Role>) this.roleRepository.findAll();
            model.addAttribute("roles", roles);
            return "pages/user/edit";
        } else {
            return "redirect:/users";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute User updatedUser) {
        // Ajoutez le traitement de validation et de mise à jour ici
        userRepository.save(updatedUser);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        // Ajoutez le traitement de suppression ici
        userRepository.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/show/{id}")
    public String showUser(@PathVariable Long id, Model model) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            model.addAttribute("user", optionalUser.get());
            return "pages/user/show";
        } else {
            return "redirect:/users";
        }
    }
}
