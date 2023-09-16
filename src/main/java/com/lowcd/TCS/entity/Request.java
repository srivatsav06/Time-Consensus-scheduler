package com.lowcd.TCS.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "requests")
@Data
@NoArgsConstructor
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "reqid")
    @Setter(value = AccessLevel.NONE)
    private Long reqId;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "participantrequests" ,
            joinColumns = @JoinColumn(name="reqid"),
            inverseJoinColumns = @JoinColumn(name="userid"))
    private Set<User> participants;

    @Column(name ="dateandtime", nullable = false)
    private LocalDateTime dateTime;

    @Column(name ="status")
    private String status;

    @Column(name ="title", nullable = false)
    private String title;

    @Column(name ="description")
    private String description;

    public Request(LocalDateTime dateTime, String status, String title, String description) {
        this.dateTime = dateTime;
        this.status = status;
        this.title = title;
        this.description = description;
    }
}
