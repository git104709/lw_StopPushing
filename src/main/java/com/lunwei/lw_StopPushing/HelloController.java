package com.lunwei.lw_StopPushing;

import com.lunwei.lw_StopPushing.model.User;
import com.lunwei.lw_StopPushing.service.UserService;
import com.lunwei.lw_StopPushing.utils.ResultVO;
import com.lunwei.lw_StopPushing.utils.ResultVOUtil;
import com.lunwei.lw_StopPushing.utils.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@Component
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping("/list")
    //@Scheduled(cron = "*/5 * * * * ?")
    @ResponseBody
    public Object list(){
        User user = userService.list();
        System.out.println(user+"当前时间戳："+System.currentTimeMillis());
        return user;
    }

    @GetMapping
    @RequestMapping("/hello")
    public String hello(){
        return "hello demo";
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
        logger.info("响应httpClient请求：doGetHaveNoParam");
        return "doGetHaveNoParam successful";
    }

    @RequestMapping("/doGetHaveParam")
    public List<User> doGetHaveParam(String name,Integer age){
        logger.info("响应httpClient请求：doGetHaveParam");
        return getUserByAge(name,age);
    }

    @PostMapping
    @RequestMapping("/doPostHaveNoParam")
    public String doPostHaveNoParam(){
        logger.info("响应httpClient请求：doPostHaveNoParam");
        return "doPostHaveNoParam successful";
    }

    @PostMapping
    @RequestMapping("/doPostHaveParam")
    public String doHttpPostParam(@RequestBody User user){
        logger.info("响应httpClient请求：doPostHaveParam");
        return "do Post params:name="+user.getName()+",age="+user.getAge();
    }

    @GetMapping
    @RequestMapping("/getProcedure")
    public List<User> getProcedure(Integer id,Integer age){
        List<User> list = userService.getProcedure(id,age);
        return list;
    }

    @PostMapping
    @RequestMapping("/addUser")
    public ResultVO addUser(@Valid User user, BindingResult bindingResult){
        ValidatorUtil.valid(bindingResult);
        //加密测试
        user.setName(passwordEncoder.encode(user.getName()));
        //解密
        // passwordEncoder.matches(password, user.getPassword())
        userService.addUser(user);
        //测试代码
//        if(passwordEncoder.matches("shun", "$2a$10$iWB8/T3/2A0hQ4PJjpp06.uecs9SCLa8bZKY2ffNktkbzugBOYmyC")){
//            System.out.println("解码成功");
//        }else{
//            System.out.println("解码失败");
//        }
        return ResultVOUtil.success();
    }


}
