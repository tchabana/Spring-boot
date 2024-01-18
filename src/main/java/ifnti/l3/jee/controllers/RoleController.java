/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifnti.l3.jee.controllers;

import ifnti.l3.jee.entities.Role;
import ifnti.l3.jee.repository.RoleRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author hafizh
 */
@Controller
@RequestMapping("/roles")
public class RoleController {
    private final RoleRepository roleRepository;

    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    
    @GetMapping
    public String findAllRoles(Model model) {
        List<Role> roles =  (List<Role>) this.roleRepository.findAll();
        model.addAttribute("roles",roles);
        return "pages/role/index";
        
    }

    @GetMapping("/create")
    public String addOneRole(Model model) {
        model.addAttribute("role", new Role());
        return "pages/role/create";
    }

    @PostMapping("/create")
    public String saveRole(@ModelAttribute Role role) {
        // Ajoutez le traitement de validation et de sauvegarde ici
        roleRepository.save(role);
        return "redirect:/roles";
    }

    @GetMapping("/edit/{id}")
    public String editRole(@PathVariable Long id, Model model) {
        Optional<Role> optionalRole = roleRepository.findById(id);
        if (optionalRole.isPresent()) {
            model.addAttribute("role", optionalRole.get());
            return "pages/role/edit";
        } else {
            return "redirect:/roles";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateRole(@PathVariable Long id, @ModelAttribute Role role) {
        // Ajoutez le traitement de validation et de mise à jour ici
        roleRepository.save(role);
        return "redirect:/roles";
    }

    @GetMapping("/delete/{id}")
    public String deleteRole(@PathVariable Long id, Model model) {
        // Ajoutez le traitement de suppression ici
        Optional<Role> roleToDelete = roleRepository.findById(id);
        if (roleToDelete.isPresent()) {
            Role role = roleToDelete.get();
    
            // Vérifier si le rôle est utilisé par des utilisateurs
            if (!role.getUsers().isEmpty()) {
                // Rôle utilisé, renvoyer un message d'erreur à l'utilisateur
                model.addAttribute("errorMessage", "Impossible de supprimer ce rôle car il est utilisé par un ou plusieurs utilisateurs.");
                return "pages/role/suppError"; // Remplacez "errorPage" par la page d'erreur de votre choix
            }
    
            // Si le rôle n'est pas utilisé, procéder à la suppression
            roleRepository.deleteById(id);
            return "redirect:/roles";
        } else {
            // Le rôle n'existe pas, renvoyer un message d'erreur à l'utilisateur ou rediriger vers une page d'erreur
            model.addAttribute("errorMessage", "Le rôle que vous essayez de supprimer n'existe pas.");
            return "pages/role/suppError"; // Remplacez "errorPage" par la page d'erreur de votre choix
        }
    }

    @GetMapping("/show/{id}")
    public String showRole(@PathVariable Long id, Model model) {
        Optional<Role> optionalUser = roleRepository.findById(id);
        if (optionalUser.isPresent()) {
            model.addAttribute("role", optionalUser.get());
            return "pages/role/show";
        } else {
            return "redirect:/roles";
        }
    }
    
}
