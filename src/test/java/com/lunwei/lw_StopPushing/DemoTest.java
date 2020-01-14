package com.lunwei.lw_StopPushing;

import com.lunwei.lw_StopPushing.model.User;
import com.lunwei.lw_StopPushing.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * ClassName:    DemoTest
 * Package:    com.test.demo
 * Description:
 * Datetime:    2020/1/14   13:50
 * Author:   zhoukaishun
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoTest {

    @Autowired
    private UserService userService;

    @Test
    public void test(){
        List<User> list = userService.getUserByAge(22);
        System.out.println(list.toString());
    }
}
