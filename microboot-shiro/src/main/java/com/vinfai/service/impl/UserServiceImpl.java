package com.vinfai.service.impl;

import com.vinfai.dao.IUserDao;
import com.vinfai.entity.User;
import com.vinfai.service.IUserService;
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
    private IUserDao userDao;

    @Override
    public User getUserByName(String name) {
        User user = userDao.selectByUserName(name);
        return user;
    }
}
