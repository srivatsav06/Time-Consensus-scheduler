package com.lowcd.TCS.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @JoinTable(name = "participantrequests",
            joinColumns = @JoinColumn(name = "reqid"),
            inverseJoinColumns = @JoinColumn(name = "userid"))
    private Set<User> participants;

    @Column(name = "dateandtime", nullable = false)
    private LocalDateTime dateTime;

    @Column(name = "status")
    private String status;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    public Request(LocalDateTime dateTime, String status, String title, String description) {
        this.dateTime = dateTime;
        this.status = status;
        this.title = title;
        this.description = description;
    }
}
