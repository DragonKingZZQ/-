package com.zzq.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzq.dao.UserDao;
import com.zzq.entity.User;
import com.zzq.service.UserService;



@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	public User getUserByOpenid(String openid) {
		
		return userDao.getUserByOpenid(openid);
	}

	public int insertUser(User user) {
		
		return userDao.insertUser(user);
	}

}
