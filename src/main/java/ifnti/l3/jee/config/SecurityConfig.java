/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifnti.l3.jee.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
/**
 *
 * @author hafiz
 */
@Configuration
public class SecurityConfig {

    // private final CustomUserDetailsService customUserDetailsService;

    // @Autowired
    // public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
    //     this.customUserDetailsService = customUserDetailsService;
    // }

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**").permitAll()
                .antMatchers("/", "/login").permitAll() // Autoriser l'accès à tout le monde à "/" et "/login"
                .antMatchers("/dashboard","/logout").authenticated() // Exiger une authentification pour "/dashboard"
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/").permitAll()
                .and()
                .csrf().disable();

		return http.build();
	}

//    @Bean
// 	public UserDetailsService userDetailsService() {
// 		UserDetails user =
// 			 User.withDefaultPasswordEncoder()
// 				.username("user")
// 				.password("password")
// 				.roles("USER")
// 				.build();

// 		return new InMemoryUserDetailsManager(user);
// 	}
}
