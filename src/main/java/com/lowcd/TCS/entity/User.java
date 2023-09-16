package com.lowcd.TCS.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name="email",nullable = false)
    private String email;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="role_fk", referencedColumnName = "roleid")
    private Role role;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "participants")
    private Set<Request> requests;

    @ManyToMany(mappedBy = "participants")
    private Set<Event> events;
}
