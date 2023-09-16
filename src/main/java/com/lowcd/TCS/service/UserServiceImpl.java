package com.lowcd.TCS.service;

import com.lowcd.TCS.entity.Role;
import com.lowcd.TCS.model.LoginBO;
import com.lowcd.TCS.entity.User;
import com.lowcd.TCS.model.UserBO;
import com.lowcd.TCS.repository.RoleRepository;
import com.lowcd.TCS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public String addUser(UserBO userBO) {
      Role role = roleRepository.findById(userBO.getRoleId()).get();
      User user1 = new User(
              userBO.getName(),
              userBO.getPassword(),
              userBO.getEmail(),
              role
      );
        userRepository.save(user1);
        return userBO.getName();
    }

    @Override
    public String loginEmployee(LoginBO loginuser) {

        User user = userRepository.findByEmail(loginuser.getEmail());


        return user==null ?"Found":"Not Found";

    }
}
