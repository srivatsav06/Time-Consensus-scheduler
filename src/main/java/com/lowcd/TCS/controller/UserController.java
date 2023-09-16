package com.lowcd.TCS.controller;

import com.lowcd.TCS.model.LoginBO;
import com.lowcd.TCS.entity.Role;
import com.lowcd.TCS.entity.User;
import com.lowcd.TCS.model.UserBO;
import com.lowcd.TCS.repository.RoleRepository;
import com.lowcd.TCS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")



public class UserController {

    @Autowired
    private UserService userservice;
    @Autowired
    private RoleRepository roleRepository;

  @PostMapping(path="/save")
  public String saveUser(@RequestBody UserBO userBO)
  {


      Role role = roleRepository.findById(userBO.getRoleId()).get();
      User user1 = new User(
              userBO.getUserid(),
              userBO.getName(),
              userBO.getPassword(),
              userBO.getEmail(),
              role
      );

      String id = userservice.addUser(user1);
      return id;
  }

    @PostMapping(path="/login")
    public String loginemployee(@RequestBody LoginBO loginuser)
    {
        String st = userservice.loginEmployee(loginuser);
        return st;
    }

}
