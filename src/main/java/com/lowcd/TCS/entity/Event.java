package com.lowcd.TCS.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="events")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "eventid")
    @Setter(value = AccessLevel.NONE)
    private Long eventId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "dateandtime", nullable = false)
    private LocalDateTime dateTime;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinTable(name = "eventparticipants" ,
            joinColumns = @JoinColumn(name="eventid"),
            inverseJoinColumns = @JoinColumn(name="userid"))
    private Set<User> participants;


    public Event(String title, String description, LocalDateTime dateTime, Set<User> participants) {
        this.title = title;
        this.description = description;
        this.dateTime = dateTime;
        this.participants = participants;
    }
}
