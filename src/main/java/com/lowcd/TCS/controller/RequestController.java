package com.lowcd.TCS.controller;

import com.lowcd.TCS.Util.ReqDtoB;
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

    @PostMapping("/create")
    public ResponseEntity<Object> createRequest(@RequestBody RequestBO requestBO )
    {
        //to data
            Request request= new Request();
            request.setDateTime(requestBO.getDateTime());
            request.setTitle(requestBO.getTitle());
            request.setDescription(requestBO.getDescription());
            request.setStatus("Pending");
            request.setParticipants(new HashSet<User>(userRepository.findAllById(requestBO.getParticipants())));
            Request newRequest = requestRepository.save(request);
            RequestBO req = ReqDtoB.fromData(newRequest);
            return new ResponseEntity<>(req, HttpStatus.CREATED);


    }
    @GetMapping("/get")
    public ResponseEntity<Object> getRequests(@RequestParam Long teacherId)
    {
        Optional<User> _user= userRepository.findById(teacherId);

        if(_user.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        User user=_user.get();// no req
        List<Request> requests = requestRepository.findRequestsByParticipantsUserid(user.getUserid());

         List<RequestBO> list=new ArrayList<>();
         for (Request r:requests)
         {
             List<User> l = userRepository.findUsersByRequestsReqId(r.getReqId());
             List<Long> ids = new ArrayList<>();
             // for each forEach(ids::add)
             for (User u: l)
             {
                 ids.add(u.getUserid());
             }
             RequestBO requestBO = ReqDtoB.fromData(r);
             requestBO.setParticipants(ids);
             list.add(requestBO);
         }

         return new ResponseEntity<>(list,HttpStatus.FOUND);

    }


}
