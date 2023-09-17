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

                event.getDateTime(),
                event.getTitle(),
                event.getDescription(),
                participants
        );
        return eventBO;
    }

}
