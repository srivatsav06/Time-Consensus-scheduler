package com.lowcd.TCS.service;


import com.lowcd.TCS.model.LoginBO;
import com.lowcd.TCS.model.UserBO;

public interface UserService {
    String addUser(UserBO userBO);
    String loginEmployee(LoginBO loginuser);
}
