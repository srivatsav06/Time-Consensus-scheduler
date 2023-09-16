package com.lowcd.TCS.repository;

import com.lowcd.TCS.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

}
