package com.lowcd.TCS.service;

import com.lowcd.TCS.entity.Event;
import com.lowcd.TCS.entity.Request;
import com.lowcd.TCS.repository.EventRepository;
import com.lowcd.TCS.repository.RequestRepository;
import com.lowcd.TCS.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.parser.Entity;
import java.util.HashSet;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    RequestRepository requestRepository;

    @Autowired
    UserRepository userRepository;

    @Transactional
    public void deleteRequest(Request request)
    {
        requestRepository.deleteRequestFromParticipantRequests(request.getReqId());
        requestRepository.deleteRequest(request.getReqId());
    }


}
