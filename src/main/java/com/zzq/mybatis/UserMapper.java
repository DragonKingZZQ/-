package com.zzq.mybatis;

import org.apache.ibatis.annotations.Param;

import com.zzq.entity.User;

public interface UserMapper {
	//根据openID查询用户
	User selectUserByOpenid(@Param("openid")String openid);
	
	//注册用户
	int insertUser(@Param("user")User user);
}
