package com.lowcd.TCS.service;

import com.lowcd.TCS.model.LoginBO;
import com.lowcd.TCS.entity.User;
import com.lowcd.TCS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;
    @Override
    public String addUser(User user) {

       User user1=new User(

               user.getUserid(),
               user.getName(),
               user.getPassword(),
               user.getEmail(),
               user.getRole()


       );
        userRepository.save(user1);
       return user1.getName();
    }

    @Override
    public String loginEmployee(LoginBO loginuser) {

        User user = userRepository.findByEmail(loginuser.getEmail());

        if(user!=null)
            return "Found";
        else
            return "Not Found";

    }
}
