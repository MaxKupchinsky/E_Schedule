package com.schedule.demo.Repository;

import com.schedule.demo.Entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  RoleRepository extends CrudRepository<Role,Integer> {
}
