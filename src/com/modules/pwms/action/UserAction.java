package com.modules.pwms.action;


import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.common.action.BaseAction;
import com.common.util.StringHelper;
import com.common.util.kendoui.KPageParam;
import com.common.util.page.PageResult;
import com.google.gson.Gson;
import com.modules.pwms.model.User;
import com.modules.pwms.service.UserService;


/**
 * 用户ACTION
 * 
 */
@Controller
@Namespace("/user")
public class UserAction extends BaseAction {

	private static final long serialVersionUID = 7418902260438614085L;

	@Autowired
	private UserService userService;
	
	private List<User> users;
	private User user;
	
	private String username;
	
	@Action(value = "user", results = { @Result(name = SUCCESS, location = "/demo/tenantpage.jsp")} )
	public String tenantmemberpage(){
	
		return SUCCESS;
	}
	
	
	@Action(value = "users", results = { @Result(name = SUCCESS, location = "/modules/system/user.jsp")} )
	public String users(){
		try {
			Gson gson = new Gson();
			String json = this.getParameter("data");
			KPageParam param = gson.fromJson(json, KPageParam.class);
			users = userService.getAllUser();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	@Action(value = "addUser", results = { @Result(name = SUCCESS, location = "/modules/system/addUser.jsp")} )
	public String addUser(){
		try {
			user.setPassword(StringHelper.string2MD5(user.getPassword()));
			userService.addUser(user);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	@Action(value = "deleteUser")
	public String deleteUser(){
		try {
			Gson gson = new Gson();
			String id = this.getParameter("id");
			userService.deleteUser(id);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnJSON(true,"OK","成功");
	}
	@Action(value = "updateUser")
	public void updateUser(){
		try {
			user.setPassword(StringHelper.string2MD5(user.getPassword()));
			userService.updateUser(user);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	return returnJSON(true,"OK","成功");
	}
	@Action(value = "updatePage", results = { @Result(name = SUCCESS, location = "/modules/system/updateUser.jsp")} )
	public String updatePage(){
		try {
			Gson gson = new Gson();
			String id = this.getParameter("id");
			user=userService.getUserById(id);
			user.setPassword(StringHelper.convertMD5(user.getPassword()));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
}
