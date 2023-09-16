package com.lowcd.TCS.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a Business Object (BO) for user login data.
 * This class is used for transferring login-related data, such as email and password,
 * between different parts of the application.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginBO {
    private String email;
    private String password;
}
