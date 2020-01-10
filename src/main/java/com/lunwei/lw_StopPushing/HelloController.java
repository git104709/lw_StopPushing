package com.lunwei.lw_StopPushing;

import com.lunwei.lw_StopPushing.model.User;
import com.lunwei.lw_StopPushing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public Object list(){
        System.out.println(123);
        return 123;
    }

}
