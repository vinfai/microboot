package com.vinfai.dao;

import com.vinfai.entity.Role;

import java.util.List;

public interface IRoleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);


    List<Role> getRolesByUserId(Integer userId);



}