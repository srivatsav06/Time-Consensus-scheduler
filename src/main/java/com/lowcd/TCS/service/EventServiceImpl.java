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

    @Override
    public Event eventFromRequest(Request request) {
        Event event = new Event(request.getTitle(),
                request.getDescription(),
                request.getDateTime(),
                new HashSet<>(request.getParticipants()));
        return eventRepository.save(event);
    }
}
