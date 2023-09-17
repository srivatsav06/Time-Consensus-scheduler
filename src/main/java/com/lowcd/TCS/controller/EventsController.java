package com.lowcd.TCS.controller;

import com.lowcd.TCS.entity.Event;
import com.lowcd.TCS.entity.User;
import com.lowcd.TCS.model.EventBO;
import com.lowcd.TCS.repository.EventRepository;
import com.lowcd.TCS.repository.UserRepository;
import com.lowcd.TCS.util.EventMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/events")
public class EventsController {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    UserRepository userRepository;

    /**
     * Retrieves a list of events associated with a specific user identified by their user ID.
     *
     * @param userId The unique identifier of the user for whom events are to be retrieved.
     * @return ResponseEntity containing a list of EventBO (Event Business Objects) if the user is found,
     * or a ResponseEntity with HTTP status NOT_FOUND if the user is not found.
     * The list of EventBO objects includes events in which the user is a participant,
     * with additional information about the participants.
     */
    @GetMapping("/get")
    public ResponseEntity<Object> getEvents(@RequestParam Long userId) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Event> events = eventRepository.findEventsByParticipantsUserid(user.get().getUserid());

        List<EventBO> list = new ArrayList<>();
        for (Event r : events) {
            List<User> l = userRepository.findUsersByEventsEventId(r.getEventId());
            List<Long> ids = new ArrayList<>();
            l.forEach(u -> ids.add(u.getUserid()));
            EventBO eventBO = EventMapper.fromData(r);
            eventBO.setParticipants(ids);
            list.add(eventBO);
        }

        return new ResponseEntity<>(list, HttpStatus.FOUND);

    }
}
