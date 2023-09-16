package com.lowcd.TCS.controller;

import com.lowcd.TCS.entity.Event;
import com.lowcd.TCS.enums.Status;
import com.lowcd.TCS.service.EventService;
import com.lowcd.TCS.service.RequestService;
import com.lowcd.TCS.util.RequestMapper;
import com.lowcd.TCS.entity.Request;
import com.lowcd.TCS.model.RequestBO;
import com.lowcd.TCS.entity.User;
import com.lowcd.TCS.repository.RequestRepository;
import com.lowcd.TCS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/requests")
public class RequestController  {
    @Autowired
    RequestRepository requestRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RequestService requestService;

    @Autowired
    EventService eventService;

    @PostMapping("/create")
    public ResponseEntity<Object> createRequest(@RequestBody RequestBO requestBO )
    {
        Request request=RequestMapper.toData(requestBO,
                    new HashSet<User>(userRepository.findAllById(requestBO.getParticipants())));
        Request newRequest = requestRepository.save(request);
        return new ResponseEntity<>(newRequest.getReqId(), HttpStatus.CREATED);
    }
    @GetMapping("/get")
    public ResponseEntity<Object> getRequests(@RequestParam Long teacherId)
    {
        Optional<User> user= userRepository.findById(teacherId);

        if(user.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Request> requests = requestRepository.findRequestsByParticipantsUserid(user.get().getUserid());

         List<RequestBO> list = new ArrayList<>();
         for (Request r:requests)
         {
             List<User> l = userRepository.findUsersByRequestsReqId(r.getReqId());
             List<Long> ids = new ArrayList<>();
             l.forEach(u->ids.add(u.getUserid()));
             RequestBO requestBO = RequestMapper.fromData(r);
             requestBO.setParticipants(ids);
             list.add(requestBO);
         }

         return new ResponseEntity<>(list,HttpStatus.FOUND);

    }

    @PostMapping("/update")
    public ResponseEntity<Object> changeStatus(Long id, Status status)
    {
        Request request= requestRepository.findById(id).get();
        if(status.equals(Status.ACCEPTED))
        {
            Event event = eventService.eventFromRequest(request);
            requestService.deleteRequest(request);
            return new ResponseEntity<>(event.getEventId(),HttpStatus.OK);
        }
        if(status.equals(Status.REJECTED))
        {
            request.setStatus(status);
            requestRepository.save(request);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
