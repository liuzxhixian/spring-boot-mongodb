package com.neo.dao;

import com.neo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *
 * </p>
 * Create by xiancreate on 2021-08-19 21:41
 */
@Mapper
public interface UserMapper {

    User getUserByUserName(@Param("username") String username);

}
