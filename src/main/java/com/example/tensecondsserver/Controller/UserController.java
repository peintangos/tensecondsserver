package com.example.tensecondsserver.Controller;

import com.example.tensecondsserver.DTO.RequestMessageUser;
import com.example.tensecondsserver.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value="/register", method = RequestMethod.POST)
    public void rejister(@RequestBody RequestMessageUser requestMessageUser){
     userService.save(requestMessageUser);
    }
}
