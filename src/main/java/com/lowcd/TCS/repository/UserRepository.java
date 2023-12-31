package com.lowcd.TCS.repository;

import com.lowcd.TCS.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);

    List<User> findUsersByRequestsReqId(Long reqId);

    User findByEmail(String email);

    List<User> findUsersByEventsEventId(Long eventId);
}
