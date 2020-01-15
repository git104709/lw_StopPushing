package com.lunwei.lw_StopPushing.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ClassName:    CustomRealm
 * Package:    com.test.demo.shiro
 * Description: 重写拒绝访问后的操作
 * Datetime:    2020/1/15   12:25
 * Author:   zhoukaishun
 */
public class CustomRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            Set<String> stringSet = new HashSet<>();
            //这里写了死值
        stringSet.add("user:show");
        stringSet.add("user:admin");
        simpleAuthorizationInfo.setStringPermissions(stringSet);
        return simpleAuthorizationInfo;
        /*
        //示例
        //角色集合
        List<String> roleList= null;
        //权限集合
        List<String> permissionList = null;
        try {
            //具体业务规则
            roleList = roleRealmService.getRoleByName(userAccount);
            permissionList =roleRealmService.getPermission(userAccount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //组装返回数据
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(roleList);
        simpleAuthorizationInfo.addStringPermissions(permissionList);*/

    }

    /**
     * 这里可以注入userService,为了方便演示，我就写死了帐号了密码
     * private UserService userService;
     * <p>
     * 获取即将需要认证的信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 获取用户名
        System.out.println("-------身份认证方法--------");
        String userName = (String) authenticationToken.getPrincipal();
        String userPwd = new String((char[]) authenticationToken.getCredentials());
        //根据用户名从数据库获取密码,这里方便测试直接写了123
        String password = "123";
        if (userName == null) {
            throw new AccountException("用户名不正确");
        } else if (!userPwd.equals(password )) {
                throw new AccountException("密码不正确");
        }
        return new SimpleAuthenticationInfo(userName, password,getName());
    }
}
