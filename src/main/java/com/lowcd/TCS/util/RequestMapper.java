package com.lowcd.TCS.util;

import com.lowcd.TCS.entity.Request;
import com.lowcd.TCS.model.RequestBO;
import com.lowcd.TCS.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RequestMapper {

    public static Request toData(RequestBO req, Set<User> users)
    {
        Request request=new Request();
        request.setDateTime(req.getDateTime());
        request.setTitle(req.getTitle());
        request.setStatus(req.getStatus());
        request.setDescription(req.getDescription());
        request.setParticipants(users);
        return request;
    }

    public static RequestBO fromData(Request request)
    {
        List<Long> participants= new ArrayList<Long>();
        Set<User> users=request.getParticipants();
        users.forEach(u -> participants.add(u.getUserid()));
        RequestBO requestBO=new RequestBO(request.getDateTime(),
                request.getStatus(),
                request.getTitle(),
                request.getDescription(),
                participants);
        return requestBO;
    }
}
