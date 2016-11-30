package com.modules.sa2ee.action;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.common.action.BaseAction;
import com.common.util.kendoui.KPageParam;
import com.common.util.page.PageResult;
import com.google.gson.Gson;
import com.modules.sa2ee.model.User;
import com.modules.sa2ee.service.UserService;



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
	
	
	
	private String username;
	
	@Action(value = "user", results = { @Result(name = SUCCESS, location = "/demo/tenantpage.jsp")} )
	public String tenantmemberpage(){
	
		return SUCCESS;
	}
	
	
	@Action("users")
	public void users(){
		try {
			Gson gson = new Gson();
			String json = this.getParameter("data");
			KPageParam param = gson.fromJson(json, KPageParam.class);
			if(param==null){
				param = new KPageParam(1,10);
			}
			
			PageResult<User> user = userService.getUserPage(param);
			this.returnObjJSON(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}
}
