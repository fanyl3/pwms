package com.modules.pwms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.util.kendoui.KPageParam;
import com.common.util.page.PageResult;
import com.modules.pwms.dao.UserDao;
import com.modules.pwms.model.User;
import com.modules.pwms.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService {
	public static final String USER_NAME = "userName";
	
	@Autowired
	private UserDao userDao;
	public PageResult<User> getUserPage(KPageParam param){
		return userDao.getUserPage(param);
	}
	
	public void addUser(User user){
		userDao.save(user);
	}

	@Override
	public User findByUserName(String username) {
		// TODO Auto-generated method stub
		List<User> userList = userDao.findByProperty(USER_NAME, username);
		return userList.size()==0?null:userList.get(0);
	}
	
	public List<User> getAllUser(){
		return userDao.findAll();
	}
	public void deleteUser(String id){
		userDao.delete(id);
	}
	public void updateUser(User user){
		userDao.update(user);
	}
	
	public User getUserById(String id){
		return userDao.find(id);
	}
	
}
