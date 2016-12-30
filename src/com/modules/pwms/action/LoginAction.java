package com.modules.pwms.action;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.common.action.BaseAction;
import com.common.util.StringHelper;
import com.modules.pwms.model.User;
import com.modules.pwms.service.impl.UserServiceImpl;


@SuppressWarnings("serial")
@Controller()
@Results(
		{ @Result(name = "success", location = "/modules/system/user.jsp"), @Result(name = "failure", location = "/modules/system/login.jsp")})
public class LoginAction extends BaseAction{
	private String username;
	private String password;

	private String errmsg;


	@Autowired
	UserServiceImpl service;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Action(value = "login",
			results = { @Result(name = SUCCESS, location = "/modules/system/user.jsp"),
			@Result(name = "failure", location = "/modules/system/login.jsp")
	})
	@Override
	public String execute() {
		User user = service.findByUserName(username);
		if(user != null){
			password = StringHelper.string2MD5(password);
			if(password.equals("MD5FAIL")){
				return "failure";
			}
			if(password.equals(user.getPassword())){
				session.put("username", username);
				session.put("id", user.getId());
				return SUCCESS;
			}
		}
		errmsg = "账号或密码错误！";
		return "failure";
	} 

}
