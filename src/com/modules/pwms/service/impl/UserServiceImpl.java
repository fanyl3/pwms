package com.modules.pwms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.util.kendoui.KPageParam;
import com.common.util.page.PageResult;
import com.modules.pwms.dao.UserDao;
import com.modules.pwms.model.User;
import com.modules.pwms.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	public PageResult<User> getUserPage(KPageParam param){
		return userDao.getUserPage(param);
	}
}
