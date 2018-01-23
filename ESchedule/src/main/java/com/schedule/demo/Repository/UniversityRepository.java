package com.schedule.demo.Repository;

import com.schedule.demo.Entities.University;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends CrudRepository<University,Integer> {
    Iterable<University> findByNameContaining(String name);
}
