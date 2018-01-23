package com.schedule.demo.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="Group_")
public class Group_ {
    public Group_() {
    }

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "univ_id")
    private University university;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "fac_id")
    private Faculty faculty;

    @JsonBackReference
    @OneToMany(mappedBy = "ugroup")
    private List<Usser> users;

    @JsonBackReference
    @OneToMany(mappedBy = "group")
    private List<Schedule> schedules;

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

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public List<Usser> getUsers() {
        return users;
    }

    public void setUsers(List<Usser> users) {
        this.users = users;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }
}
