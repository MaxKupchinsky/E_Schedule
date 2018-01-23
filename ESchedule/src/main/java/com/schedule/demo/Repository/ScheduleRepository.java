package com.schedule.demo.Repository;

import com.schedule.demo.Entities.Schedule;
import org.springframework.data.repository.CrudRepository;

public interface ScheduleRepository extends CrudRepository<Schedule,Integer> {
}
