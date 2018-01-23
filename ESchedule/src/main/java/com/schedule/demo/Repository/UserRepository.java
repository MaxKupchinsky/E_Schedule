package com.schedule.demo.Repository;

import com.schedule.demo.Entities.Usser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Usser,Integer>{
    Usser findByLogin(String login);
}
