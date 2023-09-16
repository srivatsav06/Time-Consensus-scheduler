package com.lowcd.TCS.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long userid;

    @Column(name="name",nullable = false)
    private  String name;

    @Column(name="password",nullable = false)
    private String password;

    @Column(name="email",nullable = false,unique = true)
    private String email;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="role_fk", referencedColumnName = "roleid")
    private Role role;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH},
            mappedBy = "participants",
            fetch = FetchType.LAZY)
    private Set<Request> requests;

    @ManyToMany(cascade = CascadeType.ALL,
            mappedBy = "participants",
            fetch = FetchType.LAZY)
    private Set<Event> events;

    public User(String name, String password, String email, Role role) {
        this(null, name, password, email, role, new HashSet<>(), new HashSet<>());
    }
}
