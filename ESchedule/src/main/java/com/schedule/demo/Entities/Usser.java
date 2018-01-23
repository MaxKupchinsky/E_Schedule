package com.schedule.demo.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name ="Usser")
public class Usser {
    public Usser() {
    }

    @Id
    @GeneratedValue
    private int id;
    private String login;
    private String password;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group_ ugroup;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "User_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @JsonManagedReference
    private Set<Role> roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Group_ getGroup() {
        return ugroup;
    }

    public void setGroup(Group_ group) {
        this.ugroup = group;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}

