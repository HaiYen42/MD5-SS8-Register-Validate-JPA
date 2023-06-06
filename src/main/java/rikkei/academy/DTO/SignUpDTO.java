package rikkei.academy.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

public class SignUpDTO {
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
    private Set<String> roleSet = new HashSet<>();

    public SignUpDTO() {
    }

    public SignUpDTO(Long id, String name, String username, String email, String password, Set<String> roleSet) {
        this.id = id;
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

    public Set<String> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<String> roleSet) {
        this.roleSet = roleSet;
    }

    @Override
    public String toString() {
        return "SignUpDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roleSet=" + roleSet +
                '}';
    }
}
