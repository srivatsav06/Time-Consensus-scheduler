package com.lowcd.TCS.util;

import com.lowcd.TCS.entity.Event;
import com.lowcd.TCS.entity.User;
import com.lowcd.TCS.model.EventBO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class EventMapper {

    /**
     * Converts an Event object to an EventBO (Event Business Object) for further processing.
     *
     * @param event The Event object to be converted.
     * @return An EventBO representation of the input Event.
     */

    public static EventBO fromData(Event event) {
        List<Long> participants = new ArrayList<Long>();
        Set<User> users = event.getParticipants();
        users.forEach(u -> participants.add(u.getUserid()));
        EventBO eventBO = new EventBO(

                event.getStartDateTime(),
                event.getEndDateTime(),
                event.getTitle(),
                event.getDescription(),
                participants
        );
        return eventBO;
    }
    /**
     * Converts a list of Event entities into a list of EventBO (Business Object) instances.
     *
     * @param events The list of Event entities to be converted.
     * @return A list of EventBO instances containing business-related data.
     */
    public static List<EventBO> fromData(List<Event> events) {
        List<EventBO> list = new ArrayList<>();
        for (Event e : events) {
            EventBO eventBO = EventMapper.fromData(e);
            list.add(eventBO);
        }
        return list;
    }

}
