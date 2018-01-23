package com.schedule.demo.Services;

import com.schedule.demo.Entities.Group_;
import com.schedule.demo.Entities.University;
import com.schedule.demo.Repository.GroupRepository;
import com.schedule.demo.Repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class Service1 {
    @Autowired
    UniversityRepository universityRepository;
    GroupRepository groupRepository;

    public University getUniversity(int id){
        return universityRepository.findOne(id);
    }

    public Iterable getUniversities(){
        return universityRepository.findAll();
    }

    public Iterable<University> universitySearch(String query){
        return universityRepository.findByNameContaining(query);
    }

}
