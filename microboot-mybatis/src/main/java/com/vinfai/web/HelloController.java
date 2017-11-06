package com.vinfai.web;

import com.vinfai.entity.UserInfo;
import com.vinfai.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vinfai
 * @since 2017-11-06
 */
@RestController
public class HelloController {

    @Autowired
    UserInfoMapper userInfoMapper;
    @RequestMapping("/show/{id}")
    public String showUser(@PathVariable("id") Integer id) {
        UserInfo userInfo = userInfoMapper.getUserById(id);
        return userInfo.toString();
    }
}
