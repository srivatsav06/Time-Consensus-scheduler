package com.lowcd.TCS.service;

import com.lowcd.TCS.entity.Event;
import com.lowcd.TCS.entity.Request;

public interface EventService {
    public Event eventFromRequest(Request request);
}
