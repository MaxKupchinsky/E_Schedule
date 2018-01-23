package com.schedule.demo.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Roles")
public class Role implements GrantedAuthority{
    @Id
    @GeneratedValue
    private int id;
    private String role;

    @ManyToMany(mappedBy = "roles")
    @JsonBackReference
    private Set<Usser> users;

    public Role() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<Usser> getUsers() {
        return users;
    }

    public void setUsers(Set<Usser> users) {
        this.users = users;
    }
    @Override
    public String getAuthority() {
        return getRole();
    }


}
