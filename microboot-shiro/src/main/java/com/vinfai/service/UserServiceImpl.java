package com.vinfai.service;

import com.vinfai.dao.UserMapper;
import com.vinfai.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户
 *
 * @author fangwenhui
 * @date 2017-12-13 20:19
 **/
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userDao;

    @Override
    public User getUserByName(String name) {
        User user = userDao.selectUserByName(name);
        return user;
    }
}
