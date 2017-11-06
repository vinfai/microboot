package com.vinfai.mapper;

import com.vinfai.entity.UserInfo;
import org.apache.ibatis.annotations.Select;

/**
 * @author vinfai
 * @since 2017-11-06
 */
public interface UserInfoMapper {

    @Select("SELECT * FROM USER_INFO WHERE id = #{id}")
    UserInfo getUserById(Integer id);

}
