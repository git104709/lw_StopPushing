package com.test.lw_StopPushing.service;

import com.test.lw_StopPushing.model.User;

import java.util.List;

public interface UserService {

    public User selectByPrimaryKey(Integer i);

    List<User> getList();
}
