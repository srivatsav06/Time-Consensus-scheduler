package com.lowcd.TCS.repository;

import com.lowcd.TCS.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> findRequestsByParticipantsUserid(Long userId);
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM participantrequests WHERE reqId = :requestId", nativeQuery = true)
    void deleteRequestFromParticipantRequests(@Param("requestId") Long requestId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM requests WHERE reqid = :requestId", nativeQuery = true)
    void deleteRequest(@Param("requestId") Long requestId);
}
