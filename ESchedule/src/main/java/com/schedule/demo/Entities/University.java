package com.schedule.demo.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="University")
public class University {
    public University() {
    }

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "university")
    private List<Group_> groups;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Group_> getGroups() {
        return groups;
    }

    public void setGroups(List<Group_> groups) {
        this.groups = groups;
    }
}
