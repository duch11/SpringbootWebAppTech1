package com.faisaljarkass.demo.services;

import com.faisaljarkass.demo.domains.MyUser;
import com.faisaljarkass.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public MyUser getUser(String username, String password){
        MyUser user2 = new MyUser();
        user2.setId(2l);
        user2.setUsername("test1");
        user2.setPassword("test1");
        user2.setRoles(new String[] {"user"});

        MyUser user = new MyUser();
        user.setId(1l);
        user.setUsername("test");
        user.setPassword("test");
        user.setRoles(new String[] {"admin"});



        if(user.getUsername().equals(username) && user.getPassword().equals(password)){
            return user;
        } else if (user2.getUsername().equals(username) && user2.getPassword().equals(password)){
            return user2;
        }

        return null;
    }

}
