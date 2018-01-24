package com.schedule.demo.Repository;

import com.schedule.demo.Entities.Faculty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends CrudRepository<Faculty,Integer> {
    Iterable<Faculty> findByNameContaining(String name);
}
