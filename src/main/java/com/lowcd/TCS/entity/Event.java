package com.lowcd.TCS.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="events")
@Data
@NoArgsConstructor
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

    @ManyToMany
    @JoinTable(name = "participants" ,
            joinColumns = @JoinColumn(name="eventid"),
            inverseJoinColumns = @JoinColumn(name="userid"))
    @Column(name = "participants")
    private Set<User> participants;

}
