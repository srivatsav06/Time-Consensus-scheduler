package com.lowcd.TCS.Util;

import com.lowcd.TCS.entity.Request;
import com.lowcd.TCS.model.RequestBO;
import com.lowcd.TCS.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReqDtoB {

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
        RequestBO requestBO=new RequestBO();
        requestBO.setDateTime(request.getDateTime());
        requestBO.setDescription(request.getDescription());
        requestBO.setTitle(request.getTitle());
        requestBO.setStatus(request.getStatus());
        List<Long> participants= new ArrayList<Long>();
        Set<User> users=request.getParticipants();
        for(User u:users)
        {
            participants.add(u.getUserid());
        }
        requestBO.setParticipants(participants);
        return requestBO;
    }
}
