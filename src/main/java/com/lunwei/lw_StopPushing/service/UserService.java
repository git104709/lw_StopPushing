package com.lunwei.lw_StopPushing.service;

import com.lunwei.lw_StopPushing.model.User;

import java.util.List;

public interface UserService {
    
    public User selectByPrimaryKey(Integer i);

    List<User> getList();

    User list();

    List<User> getUserByAge(Integer age);
}
