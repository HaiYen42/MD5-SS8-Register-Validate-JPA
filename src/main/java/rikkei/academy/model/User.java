package rikkei.academy.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"), @UniqueConstraint(columnNames = "email")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 2, max = 10)
    private String name;
    @Size(min = 2, max = 10)
    private String username;
    @Email
    private String email;
    @NotNull
    @Size(min = 2, max = 6)
    private String password;
    private String avatar;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_role", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    Set<Role> roleSet = new HashSet<>();

    public User() {
    }

    public User(Long id, String name, String username, String email, String password, String avatar, Set<Role> roleSet) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.roleSet = roleSet;
    }

    public User(String email, String name, String password, String username, Set<Role> roleSet) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roleSet = roleSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", roleSet=" + roleSet +
                '}';
    }
}
