package com.lowcd.TCS.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="roleid", nullable = false,unique = true)
    private Integer roleId;

    @Column(name="rolename", nullable = false,unique = true)
    private String roleName;
}
