package com.lunwei.lw_StopPushing.shiro;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

import javax.servlet.ServletRequest;

/**
 * ClassName:    ShiroFormAuthenticationFilter
 * Package:    com.test.demo.shiro
 * Description: 重写拒绝访问后的操作
 * Datetime:    2020/1/15   13:25
 * Author:   zhoukaishun
 */
public class ShiroFormAuthenticationFilter extends FormAuthenticationFilter {

    private static final Logger log = LoggerFactory.getLogger(ShiroFormAuthenticationFilter.class);


    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (this.isLoginRequest(request, response)) {
            if (this.isLoginSubmission(request, response)) {
                if (log.isTraceEnabled()) {
                    log.trace("Login submission detected.  Attempting to execute login.");
                }

                return this.executeLogin(request, response);
            } else {
                if (log.isTraceEnabled()) {
                    log.trace("Login page view.");
                }

                return true;
            }
        } else {
            HttpServletRequest req = (HttpServletRequest)request;
            HttpServletResponse resp = (HttpServletResponse)response;
            if (req.getMethod().equals(RequestMethod.OPTIONS.name())) {
                resp.setStatus(HttpStatus.OK.value());
                return true;
            } else {
                if (log.isTraceEnabled()) {
                    log.trace("Attempting to access a path which requires authentication.  Forwarding to the Authentication url [{}]" ,this.getLoginUrl());
                }
                /**
                 * 在这里实现自己想返回的信息
                 */
                resp.setHeader("Access-Control-Allow-Origin", req.getHeader("Origin"));
                resp.setHeader("Access-Control-Allow-Credentials", "true");
                resp.setContentType("application/json; charset=utf-8");
                resp.setCharacterEncoding("UTF-8");
                PrintWriter out = resp.getWriter();
                out.println("未登录授权");
                out.flush();
                out.close();
                return false;
            }
        }
    }


}
