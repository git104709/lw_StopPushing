package com.lunwei.lw_StopPushing.service.impl;

import com.lunwei.lw_StopPushing.service.UserService;
import com.lunwei.lw_StopPushing.mapper.UserMapper;
import com.lunwei.lw_StopPushing.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByPrimaryKey(Integer id) {
               User user = userMapper.selectByPrimaryKey(id);
               return user;
    }

    @Override
    public List<User> getList() {
        return userMapper.getList();
    }

    @Override
    public User list() {
        return userMapper.list();
    }
}
