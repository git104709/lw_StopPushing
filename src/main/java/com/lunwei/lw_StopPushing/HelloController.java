package com.lunwei.lw_StopPushing;

import com.lunwei.lw_StopPushing.model.User;
import com.lunwei.lw_StopPushing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@Component
public class HelloController {

    @Autowired
    private UserService userService;

    @RequestMapping("list")
    @Scheduled(cron = "*/5 * * * * ?")
    @ResponseBody
    public Object list(){
        User user = userService.list();
            System.out.println(user);
        return user;
    }

    @RequestMapping("/getUser")
    public User getUser(){
        User user = userService.selectByPrimaryKey(1);
        return user;
    }

}
