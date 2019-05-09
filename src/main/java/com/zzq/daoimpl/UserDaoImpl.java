package com.zzq.daoimpl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zzq.dao.UserDao;
import com.zzq.entity.User;
import com.zzq.mybatis.UserMapper;


@Repository
public class UserDaoImpl implements UserDao{
	
	@Resource
	private UserMapper userMapper;
	
	public User getUserByOpenid(String openid) {
		
		return userMapper.selectUserByOpenid(openid);
	}

	public int insertUser(User user) {
		
		return userMapper.insertUser(user);
	}
	

}
