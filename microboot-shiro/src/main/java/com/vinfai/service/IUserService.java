package com.vinfai.service;


import com.vinfai.dto.UserDTO;
import com.vinfai.entity.User;

import java.util.List;
import java.util.Set;

public interface IUserService {

    User getUserByName(String name);

    Set<String> getRolesByUserId(Integer userId);

    Set<String> getPermissionsByUserId(Integer userId);

    List<UserDTO> getUserList();


    Boolean saveOrUpdate(User user);

    Boolean delete(Integer userId);
}
