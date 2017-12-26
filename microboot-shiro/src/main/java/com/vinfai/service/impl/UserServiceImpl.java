package com.vinfai.service.impl;

import com.google.common.collect.Sets;
import com.vinfai.dao.IResourceDao;
import com.vinfai.dao.IRoleDao;
import com.vinfai.dao.IUserDao;
import com.vinfai.dto.ResourceDTO;
import com.vinfai.dto.RoleDTO;
import com.vinfai.dto.UserDTO;
import com.vinfai.entity.Resource;
import com.vinfai.entity.Role;
import com.vinfai.entity.User;
import com.vinfai.service.IUserService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Autowired
    private IRoleDao roleDao;

    @Autowired
    private IResourceDao resourceDao;


    @Override
    public User getUserByName(String name) {
        User user = userDao.selectByUserName(name);
        return user;
    }
    @Override
    public Set<String> getRolesByUserId(Integer userId) {

        Set<String> roleSet = Sets.newHashSet();
        List<Role> roleList = roleDao.getRolesByUserId(userId);
        if (CollectionUtils.isNotEmpty(roleList)) {
            for (Role role : roleList) {
                roleSet.add(role.getRoleKey());
            }

        }
        return roleSet;
    }

    @Override
    public Set<String> getPermissionsByUserId(Integer userId) {
        Set<String> premissoinSet = Sets.newHashSet();
        List<Role> roleList = roleDao.getRolesByUserId(userId);

        if (CollectionUtils.isNotEmpty(roleList)) {
            for (Role role : roleList) {
                List<Resource> resourceList =  resourceDao.getResourcesByRoleId(role.getId());
                if (CollectionUtils.isNotEmpty(resourceList)) {
                    for (Resource resource : resourceList) {
                        premissoinSet.add(resource.getSourceKey());
                    }
                }
            }
        }
        return premissoinSet;
    }


    @Override
    public Boolean saveOrUpdate(User user) {

        return null;
    }

    @Override
    public Boolean delete(Integer userId) {
        return null;
    }

    @Override
    public List<UserDTO> getUserList() {
        List<User> userList =  userDao.selectUserList();
        List<UserDTO> dtoList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(userList)) {
            for (User user : userList) {
                UserDTO userDTO = new UserDTO();
                BeanUtils.copyProperties(user,userDTO);
                List<Role> roles = roleDao.getRolesByUserId(user.getId());
                List<RoleDTO> targetList = copyProperties(roles,RoleDTO.class);
                Set<RoleDTO> roleSet = convertList2Set(targetList);
                userDTO.setRoles(roleSet);

                List<Resource> resourceList = resourceDao.getResourcesByRoleId(user.getId());
                List<ResourceDTO> targetList1 = copyProperties(roles,ResourceDTO.class);
                Set<ResourceDTO> resourceDTOSet = convertList2Set(targetList1);
                userDTO.setResources(resourceDTOSet);
                dtoList.add(userDTO);
            }
        }
       return dtoList;
    }

    private static <S,T> List<T> copyProperties(List<S> sourceList,Class<T> clazz) {
        List<T> targetList = new ArrayList<>();
        try {
            if (CollectionUtils.isNotEmpty(sourceList)) {
                for (S source : sourceList) {
                    T target =  clazz.newInstance();
                    BeanUtils.copyProperties(source, target);
                    targetList.add(target);
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return targetList;
    }

    private <T> Set<T> convertList2Set(List<T> list){
        Set<T> set = new HashSet<>();
        if (CollectionUtils.isNotEmpty(list)) {
            for (T t : list) {
                set.add(t);
            }
        }

        return set;
    }
}
