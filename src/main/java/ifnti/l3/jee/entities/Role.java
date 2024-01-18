package ifnti.l3.jee.entities;
        
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String roleName;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();
    public Role() {
        
    }
    public Role(String roleName) {
        this.roleName = roleName;
    }
    public Long getId() {
      return this.id;
    }
    public String getRoleName() {
        return roleName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

   
}