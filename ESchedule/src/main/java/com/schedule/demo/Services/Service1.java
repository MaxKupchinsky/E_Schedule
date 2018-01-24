package com.schedule.demo.Services;

import com.schedule.demo.Entities.Faculty;
import com.schedule.demo.Entities.Group_;
import com.schedule.demo.Entities.University;
import com.schedule.demo.Repository.FacultyRepository;
import com.schedule.demo.Repository.GroupRepository;
import com.schedule.demo.Repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class Service1 {
    @Autowired
    UniversityRepository universityRepository;
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    FacultyRepository facultyRepository;

    public University getUniversity(int id){
        return universityRepository.findOne(id);
    }

    public Iterable getUniversities(){
        return universityRepository.findAll();
    }

    public Iterable<University> universitySearch(String query){
        return universityRepository.findByNameContaining(query);
    }

    ////
    public Faculty getFaculty(int id){
        return facultyRepository.findOne(id);
    }

    public Iterable getFaculties(){
        return facultyRepository.findAll();
    }

    public Iterable<Faculty> facultySearch(String query){
        return facultyRepository.findByNameContaining(query);
    }

    ////
    public Group_ getGroup(int id){
        return groupRepository.findOne(id);
    }

    public Iterable getGroups(){
        return groupRepository.findAll();
    }

    public Iterable<Group_> groupSearch(String universityPath, String facultyPath){
        return groupRepository.findByUniversityContainingOrFacultyContaining(universityPath,facultyPath);
    }

}
