package com.modules.pwms.service;

import java.util.List;

import com.common.util.kendoui.KPageParam;
import com.common.util.page.PageResult;
import com.modules.pwms.model.User;

public interface UserService {
	public PageResult<User> getUserPage(KPageParam param);
	
	public User findByUserName(String username);
	
	public List<User> getAllUser();
	
	public void addUser(User user);
	
	public void deleteUser(String id);
	
	public void updateUser(User user);
	
	public User getUserById(String id);
}
