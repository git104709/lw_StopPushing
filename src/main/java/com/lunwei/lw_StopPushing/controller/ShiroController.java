package com.lunwei.lw_StopPushing.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * ClassName:    TUserController
 * Package:    com.test.demo.controller
 * Description:
 * Datetime:    2020/1/15   10:40
 * Author:   zhoukaishun
 */

@RestController
@RequestMapping("/shiro")
public class ShiroController {

    /**
     * 身份认证测试接口
     * @return
     */
    @GetMapping
    @RequestMapping("/admin")
    public String admin() {
        return "admin success";
    }

    /**
     * 角色认证测试接口
     * @return
     */
    @GetMapping
    @RequestMapping("/student")
    public String student() {
        return "student success";
    }

    /**
     * 权限认证测试接口
     * @return
     */
    @GetMapping
    @RequestMapping("/teacher")
    public String teacher() {
        return "teacher success";
    }


    @PostMapping
    @RequestMapping("/login")
    public String login(String username,String password) {
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            return "未知账户";
        } catch (IncorrectCredentialsException ice) {
            return "密码不正确";
        } catch (LockedAccountException lae) {
            return "账户已锁定";
        } catch (ExcessiveAttemptsException eae) {
            return "用户名或密码错误次数过多";
        } catch (AuthenticationException ae) {
            return "用户名或密码不正确！";
        }
        if (subject.isAuthenticated()) {
            return "登录成功";
        } else {
            token.clear();
            return "登录失败";
        }
    }
    @GetMapping
    @RequestMapping("/success")
    public String success() {
        return "success success";
    }

    @GetMapping
    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "logout success";
    }
}

