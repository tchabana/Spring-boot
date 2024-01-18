// /*
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
//  */
// package ifnti.l3.jee.config;

// /**
//  *
//  * @author hafiz
//  */
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// import ifnti.l3.jee.repository.UserRepository;

// @Service
// public class CustomUserDetailsService implements UserDetailsService {

//     @Autowired
//     private UserRepository userRepository;  // Assurez-vous d'avoir une classe UserRepository correspondante

//     //@Override
//     // public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//     //     // Récupérer l'utilisateur depuis la base de données
//     //     User user = userRepository.findByUsername(username)
//     //         .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

//     //     // Créer un objet UserDetails à partir des détails de l'utilisateur
//     //     return User.builder()
//     //         .username(user.getUsername())
//     //         .password(user.getPassword())  // Assurez-vous que le mot de passe est déjà encodé
//     //         .roles("ROLE_USER")  // Vous pouvez attribuer des rôles à l'utilisateur si nécessaire
//     //         .build();
//     // }
// }