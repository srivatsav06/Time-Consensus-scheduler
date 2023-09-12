package com.lowcd.TCS.model;
import java.util.List;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
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

    @ManyToMany
    @JoinTable(name = "studentrequests" ,
            joinColumns = @JoinColumn(name="userid"),
            inverseJoinColumns = @JoinColumn(name="reqid"))
    private List<User> studentId;

    @ManyToMany
    @JoinTable(name="teacherrequests" ,
            joinColumns = @JoinColumn(name="userid"),
            inverseJoinColumns = @JoinColumn(name="reqid"))
    @Column(name ="teacherid")
    private List<User> teacherId;

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
