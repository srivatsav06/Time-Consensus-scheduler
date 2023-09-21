package com.lowcd.TCS.util;

import com.lowcd.TCS.entity.Request;
import com.lowcd.TCS.entity.User;
import com.lowcd.TCS.model.RequestBO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Utility class for mapping between Request and RequestBO objects.
 */
public class RequestMapper {

    /**
     * Maps a RequestBO object and a set of users to a Request object.
     *
     * @param req   The RequestBO object containing request data.
     * @param users The set of users participating in the request.
     * @return The mapped Request object.
     */
    public static Request toData(RequestBO req, Set<User> users) {
        Request request = new Request();
        request.setStartDateTime(req.getStartDateTime());
        request.setEndDateTime(req.getEndDateTime());
        request.setTitle(req.getTitle());
        request.setStatus(req.getStatus());
        request.setDescription(req.getDescription());
        request.setParticipants(users);
        return request;
    }

    /**
     * Maps a Request object to a RequestBO object.
     *
     * @param request The Request object to be mapped.
     * @return The mapped RequestBO object.
     */
    public static RequestBO fromData(Request request) {
        List<Long> participants = new ArrayList<Long>();
        Set<User> users = request.getParticipants();
        users.forEach(u -> participants.add(u.getUserid()));
        RequestBO requestBO = new RequestBO(request.getStartDateTime(),
                request.getEndDateTime(),
                request.getStatus(),
                request.getTitle(),
                request.getDescription(),
                participants);
        return requestBO;
    }
}
