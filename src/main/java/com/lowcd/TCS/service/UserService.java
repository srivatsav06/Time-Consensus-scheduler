package com.lowcd.TCS.service;

import com.lowcd.TCS.model.LoginBO;
import com.lowcd.TCS.entity.User;
import org.springframework.stereotype.Service;

public interface UserService {
    String addUser(User user);

    String loginEmployee(LoginBO loginuser);
}
