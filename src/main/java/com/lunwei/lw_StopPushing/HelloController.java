package com.lunwei.lw_StopPushing;

import com.lunwei.lw_StopPushing.model.User;
import com.lunwei.lw_StopPushing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Component
public class HelloController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    @Scheduled(cron = "*/5 * * * * ?")
    @ResponseBody
    public Object list(){
        User user = userService.list();
        System.out.println(user+"当前时间戳："+System.currentTimeMillis());
        return user;
    }

    @GetMapping
    @RequestMapping("/getUserByAge")
    public List<User> getUserByAge(String name,Integer age){
        System.out.println("参数name="+name);
        List<User> list = userService.getUserByAge(age);
        return list;
    }
    @RequestMapping("/testHttpCLient")
    public String testHttpClient(){
        return "successful";
    }

    @RequestMapping("/httpclientGetParam")
    public List<User> httpclientGetParam(String name,Integer age){
        return getUserByAge(name,age);
    }

    @PostMapping
    @RequestMapping("/doHttpPost")
    public String doHttpPost(){
        return "do Post successful";
    }

    @PostMapping
    @RequestMapping("/doHttpPostParam")
    public String doHttpPostParam(@RequestBody User user){
        return "do Post params:name="+user.getName()+",age="+user.getAge();
    }

}
