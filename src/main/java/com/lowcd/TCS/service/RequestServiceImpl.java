package com.lowcd.TCS.service;

import com.lowcd.TCS.entity.Request;
import com.lowcd.TCS.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    RequestRepository requestRepository;

    /**
     * Deletes a Request and its associated records from the request repository.
     *
     * @param request The Request object to be deleted.
     */
    @Transactional
    public void deleteRequest(Request request) {
        requestRepository.deleteRequestFromParticipantRequests(request.getReqId());
        requestRepository.deleteRequest(request.getReqId());
    }


}
