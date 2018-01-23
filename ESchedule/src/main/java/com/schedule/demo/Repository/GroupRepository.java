package com.schedule.demo.Repository;

import com.schedule.demo.Entities.Group_;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends CrudRepository<Group_,Integer>{
    //Iterable<Group_> findByUniversityContainingOrFacultyContaining(String universityPath, String facultyPath);
}
