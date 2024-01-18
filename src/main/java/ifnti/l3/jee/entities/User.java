package ifnti.l3.jee.entities;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String username;
    private String prenom;
    private String pwd;
    private String email;
    private String telphone;
    private Boolean enabled;
    @ManyToMany
    @JoinTable(
        name = "users_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {
    }
    public User(Long id, String nom, String username, String prenom, String pwd, String email, String telphone, Boolean enabled) {
        this.id = id;
        this.nom = nom;
        this.username = username;
        this.prenom = prenom;
        this.pwd = pwd;
        this.email = email;
        this.telphone = telphone;
        this.enabled = enabled;
    }
    public User(Long id, String nom, String username, String prenom, String pwd, String email, String telphone, Boolean enabled,Set<Role> roles) {
        this.id = id;
        this.nom = nom;
        this.username = username;
        this.prenom = prenom;
        this.pwd = pwd;
        this.email = email;
        this.telphone = telphone;
        this.enabled = enabled;
        this.roles = roles;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return  null;
    }
    @Override
    public String getPassword() {
        try {
            return this.getPassword();
        } catch (Exception e) {
            throw new UnsupportedOperationException("Unimplemented method 'getPassword'");
        }
    }
    @Override
    public boolean isAccountNonExpired() {
        return this.enabled;
    }
    @Override
    public boolean isAccountNonLocked() {
        return this.enabled;    
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return this.enabled; 
    }
    @Override
    public boolean isEnabled() {
        return this.enabled; 
    }
}