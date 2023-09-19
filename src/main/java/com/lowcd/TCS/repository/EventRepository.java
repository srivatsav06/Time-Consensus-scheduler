package com.lowcd.TCS.repository;

import com.lowcd.TCS.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findEventsByParticipantsUserid(Long userid);

    List<Event> findEventsByParticipantsUseridAndDateTimeBetween(Long userid, LocalDateTime startDateTime, LocalDateTime endDateTime);
}
