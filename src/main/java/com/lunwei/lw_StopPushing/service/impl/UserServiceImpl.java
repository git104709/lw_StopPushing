package com.lunwei.lw_StopPushing.service.impl;

import com.lunwei.lw_StopPushing.service.UserService;
import com.lunwei.lw_StopPushing.mapper.UserMapper;
import com.lunwei.lw_StopPushing.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<User> getUserByAge(Integer age) {
        return userMapper.getUserByAge(age);
    }

    @Override
    public List<User> getProcedure(Integer id, Integer age) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id",id);
        params.put("age",age);
        return userMapper.getProcedure(params);
    }
}
