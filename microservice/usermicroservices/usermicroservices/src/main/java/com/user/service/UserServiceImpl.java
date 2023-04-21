package com.user.service;

import com.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements  UserService{
    List<User> userList= List.of(
            new User(101l,"ranjith","9876543210"),
            new User(102l,"sai","0123456789"),
            new User(103l,"biswa","951620348"),
            new User(104l,"manoj","952174852"),
            new User(105l,"shravan","786520145"),
            new User(106l,"keerthana","7410258741")
            );
    @Override
    public User getUser(Long id) {
        return userList.stream().filter(user -> user.getUserid()==id).findAny().orElse(null);
    }
}
