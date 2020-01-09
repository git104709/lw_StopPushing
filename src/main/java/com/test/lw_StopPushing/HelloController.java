package com.test.lw_StopPushing;

import com.test.lw_StopPushing.model.User;
import com.test.lw_StopPushing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class HelloController {

    @Autowired
    private UserService userService;

    @GetMapping
    @RequestMapping("/hello")
    public String hello(){
        return "hello lw_StopPushing";
    }

    @GetMapping
    @RequestMapping("/getUser")
    public User getUser(){
        User user = userService.selectByPrimaryKey(1);
        return user;
    }

    @GetMapping
    @RequestMapping("/getList")
    public List<User> getList(){
        List<User> list = userService.getList();
        return list;
    }

}
