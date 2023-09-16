package com.lowcd.TCS.service;


import com.lowcd.TCS.model.LoginBO;
import com.lowcd.TCS.entity.User;
import com.lowcd.TCS.model.UserBO;
import org.springframework.stereotype.Service;

public interface UserService {
    String addUser(UserBO userBO);

    String loginEmployee(LoginBO loginuser);
}
