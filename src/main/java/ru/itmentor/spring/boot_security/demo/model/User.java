package ru.itmentor.spring.boot_security.demo.model;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "people")
public class User implements UserDetails, Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    @Column(name = "username")
    private String username;

    @Min(value = 0, message = "Age should be greater than 0")
    @Column(name = "age")
    private int age;

    @Column(name = "email")
    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(value = FetchMode.JOIN)
    @Column(name = "roles")
    @JoinTable(
            name = "myroles_people",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn ( name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;


    public User() {
    }

    public User(String username, Integer age, String email) {
        this.username = username;
        this.age = age;
    }

    public User(String username, Integer age, String email, String password, Set<Role> roles) {
        this.username = username;
        this.age = age;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }


    public void setId(Long id){
        this.id = id;
    }

    public Long getId () {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public void setPassword(String userPassword) {
        this.password = userPassword;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    @Override
    public String toString() {
        return  "id=" + id +
                ", name='" + username + '\'' +
                ", age=" + age;
    }


}