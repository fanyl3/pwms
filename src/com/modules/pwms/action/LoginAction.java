package com.modules.pwms.action;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.common.action.BaseAction;
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
			password = password2Md5(password);
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

	public static String password2Md5(String plainText) {
		try { 
			plainText = plainText.trim();
			MessageDigest md = MessageDigest.getInstance("MD5"); 
			md.update(plainText.getBytes()); 
			byte b[] = md.digest(); 
			int i; 
			StringBuffer buf = new StringBuffer(""); 
			for (int offset = 0; offset < b.length; offset++) { 
				i = b[offset]; 
				if(i<0) 
					i+= 256; 
				if(i<16) buf.append("0"); 
				buf.append(Integer.toHexString(i));
			} 
			return buf.toString().substring(8,24).toLowerCase(); 
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace(); 
			return "MD5FAIL";
		} 
	} 
}
