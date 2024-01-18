package ifnti.l3.jee.controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Authentification {
    
    @RequestMapping("/login")
    public String login(){
        return "pages/auth-login";
    }
    
    @PostMapping("/login")
    public String loginSubmit() {
        
        return "redirect:/dashboard?loginSuccess=true";
    }

    @RequestMapping("/register")
    public String register(){
        return "pages/auth-register";
    }
    
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, (org.springframework.security.core.Authentication) authentication);
        }

        // Redirigez vers la page de connexion après la déconnexion
        return "redirect:/";
    }
}
