package com.lowcd.TCS.repository;

import com.lowcd.TCS.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> findRequestsByParticipantsUserid(Long userId);
}
