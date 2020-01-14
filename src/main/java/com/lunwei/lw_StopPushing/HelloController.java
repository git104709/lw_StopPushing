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
    @RequestMapping("/doGetHaveNoParam")
    public String doGetHaveNoParam(){
        return "successful";
    }

    @RequestMapping("/doGetHaveParam")
    public List<User> doGetHaveParam(String name,Integer age){
        return getUserByAge(name,age);
    }

    @PostMapping
    @RequestMapping("/doPostHaveNoParam")
    public String doPostHaveNoParam(){
        return "do Post successful";
    }

    @PostMapping
    @RequestMapping("/doPostHaveParam")
    public String doHttpPostParam(@RequestBody User user){
        return "do Post params:name="+user.getName()+",age="+user.getAge();
    }

    @GetMapping
    @RequestMapping("/getProcedure")
    public List<User> getProcedure(Integer id,Integer age){
        List<User> list = userService.getProcedure(id,age);
        return list;
    }


}
