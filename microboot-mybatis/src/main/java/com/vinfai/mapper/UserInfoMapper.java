package com.vinfai.mapper;

import com.vinfai.entity.UserInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author vinfai
 * @since 2017-11-06
 */
public interface UserInfoMapper {

    @Select("SELECT id,user_name as userName,password FROM USER_INFO WHERE id = #{id}")
    UserInfo getUserById(Integer id);

    @Delete("DELETE FROM USER_INFO WHERE ID = #{id}")
    void delUserInfo(Integer id);

    @Insert("insert into user_info(id,user_name,password) values(#{id},#{userName},#{password})")
    void insert(UserInfo userInfo);

    @Select("select * from user_info")
    List<UserInfo> getAll();
}
