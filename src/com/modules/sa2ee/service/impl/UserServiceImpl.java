package com.modules.sa2ee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.util.kendoui.KPageParam;
import com.common.util.page.PageResult;
import com.modules.sa2ee.dao.UserDao;
import com.modules.sa2ee.model.User;
import com.modules.sa2ee.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	public PageResult<User> getUserPage(KPageParam param){
		return userDao.getUserPage(param);
	}
	
	public void addUser(User user){
		userDao.save(user);
	}
}
