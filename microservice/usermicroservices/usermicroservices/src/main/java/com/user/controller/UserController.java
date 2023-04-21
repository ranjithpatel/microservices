package com.user.controller;

import com.user.entity.User;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/{userid}")
    public User getUser(@PathVariable("userid") Long id){

      User user=  userService.getUser(id);

        List contacts = restTemplate.getForObject("http://9002/contact/user/"+user.getUserid(), List.class);
        user.setContacts(contacts);
        return user ;

    }
}
