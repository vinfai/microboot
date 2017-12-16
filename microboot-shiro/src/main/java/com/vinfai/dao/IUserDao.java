package com.vinfai.dao;

import com.vinfai.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByUserName(@Param("userName") String userName);


    List<User> selectUserList();

}