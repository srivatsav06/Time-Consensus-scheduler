package com.lowcd.TCS.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBO  {

    private Long userid;

    private  String name;

    private String password;

    private String email;

    private Integer roleId;
}
