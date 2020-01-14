package com.lunwei.lw_StopPushing.mapper;

import com.lunwei.lw_StopPushing.model.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> getList();

    User list();

    List<User> getUserByAge(Integer age);

    List<User> getProcedure(Map<String, Object> params);
}