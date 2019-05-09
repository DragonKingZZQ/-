package com.zzq.resource;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzq.entity.User;
import com.zzq.service.UserService;

@Controller
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("getUserByOpenid")
	@ResponseBody
	public User getUserByOpenid(@RequestParam("openid")String openid) {
		User user = userService.getUserByOpenid(openid);
		return user;
	}
	
	@RequestMapping("registe")
	@ResponseBody
	public Map<String,String> registe(User user) {
		User getuser = userService.getUserByOpenid(user.getOpenid());
		System.out.println(user.getOpenid()+"openid的值");
		Map<String,String> map = new HashMap<String,String>();
		if(getuser == null) {   //如果是新人，插入信息
			int registeok = userService.insertUser(user);			
			if(registeok==1) {
				map.put("result", "registeok newpeople");
				map.put("code","1");
				return map;
			}
			else {
				map.put("result", "registe errorInsert");
				map.put("code","0");
				return map;
			}
		}else {   //如果不是新人直接返回查询信息
			map.put("result","registeok oldpeople");
			map.put("code", "2");
			return map;
		}
	}
	
	
	
}
