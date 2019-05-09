package com.zzq.service;

import com.zzq.entity.User;

public interface UserService {
	
	User getUserByOpenid(String openid);
	
	int insertUser(User user);
}
