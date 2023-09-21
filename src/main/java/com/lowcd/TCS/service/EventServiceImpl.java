package com.lowcd.TCS.service;

import com.lowcd.TCS.entity.Event;
import com.lowcd.TCS.entity.Request;
import com.lowcd.TCS.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    EventRepository eventRepository;

    /**
     * Creates a new Event based on the information from a given Request and saves it to the Event repository.
     *
     * @param request The Request object from which to create the Event.
     * @return The newly created Event object, which has been saved to the repository.
     */
    @Override
    public Event eventFromRequest(Request request) {
        Event event = new Event(request.getTitle(),
                request.getDescription(),
                request.getStartDateTime(),
                request.getEndDateTime(),
                new HashSet<>(request.getParticipants()));
        return eventRepository.save(event);
    }
}
