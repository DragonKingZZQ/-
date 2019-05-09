package com.zzq.dao;

import com.zzq.entity.User;

public interface UserDao {
	User getUserByOpenid(String openid);
	
	int insertUser(User user);
}
