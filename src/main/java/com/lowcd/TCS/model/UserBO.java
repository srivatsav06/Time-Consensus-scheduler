package com.lowcd.TCS.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a Business Object (BO) for user data.
 * This class is used for transferring user-related data, such as user ID, name, password,
 * email, and role ID, between different parts of the application.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBO {
    private Long userid;
    private String name;
    private String password;
    private String email;
    private Integer roleId;
}
