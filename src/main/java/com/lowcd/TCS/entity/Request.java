package com.lowcd.TCS.entity;
import com.lowcd.TCS.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "requests")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "reqid")
    @Setter(value = AccessLevel.NONE)
    private Long reqId;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinTable(name = "participantrequests" ,
            joinColumns = @JoinColumn(name="reqid"),
            inverseJoinColumns = @JoinColumn(name="userid"))
    private Set<User> participants;

    @Column(name ="dateandtime", nullable = false)
    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    @Column(name ="status")
    private Status status;

    @Column(name ="title", nullable = false)
    private String title;

    @Column(name ="description")
    private String description;

    public Request(LocalDateTime dateTime, Status status, String title, String description) {
        this.dateTime = dateTime;
        this.status = status;
        this.title = title;
        this.description = description;
    }

    public void addUser(User user)
    {
        this.participants.add(user);
        user.getRequests().add(this);
    }
    public void removeUser(User user)
    {
        this.participants.remove(user);
        user.getRequests().remove(this);
    }
}
