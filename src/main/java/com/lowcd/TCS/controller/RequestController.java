package com.lowcd.TCS.controller;

import com.lowcd.TCS.entity.Request;
import com.lowcd.TCS.entity.User;
import com.lowcd.TCS.model.RequestBO;
import com.lowcd.TCS.repository.RequestRepository;
import com.lowcd.TCS.repository.UserRepository;
import com.lowcd.TCS.util.RequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/requests")
public class RequestController {
    @Autowired
    RequestRepository requestRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/create")
    public ResponseEntity<Object> createRequest(@RequestBody RequestBO requestBO) {
        Request request = RequestMapper.toData(requestBO,
                new HashSet<User>(userRepository.findAllById(requestBO.getParticipants())));
        Request newRequest = requestRepository.save(request);
        return new ResponseEntity<>(newRequest.getReqId(), HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getRequests(@RequestParam Long teacherId) {
        Optional<User> user = userRepository.findById(teacherId);

        if (user.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Request> requests = requestRepository.findRequestsByParticipantsUserid(user.get().getUserid());

        List<RequestBO> list = new ArrayList<>();
        for (Request r : requests) {
            List<User> l = userRepository.findUsersByRequestsReqId(r.getReqId());
            List<Long> ids = new ArrayList<>();
            l.forEach(u -> ids.add(u.getUserid()));
            RequestBO requestBO = RequestMapper.fromData(r);
            requestBO.setParticipants(ids);
            list.add(requestBO);
        }

        return new ResponseEntity<>(list, HttpStatus.FOUND);

    }


}
