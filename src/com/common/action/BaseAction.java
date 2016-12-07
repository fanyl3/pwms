package com.common.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.common.util.json.JsonUtils;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements ServletContextAware,
						ServletResponseAware, ServletRequestAware, SessionAware{
	private static final String RETURN_NAME = "success";
	private static final long serialVersionUID = 1L;
	public final transient Log log = LogFactory.getLog(super.getClass());
	public static final String INFO = "info";
	public static final String EDIT = "edit"; 

	protected ServletContext servletContext;

	protected HttpServletRequest httpServletRequest;

	protected HttpServletResponse httpServletResponse;

	protected HttpSession httpSession;

	protected Map<String, Object> session;
	
	int page;

	public void setServletContext(ServletContext context) {
		this.servletContext = context;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.httpServletResponse = response;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.httpServletRequest = request;
		this.httpSession = request.getSession();
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	protected PrintWriter getOut() {
		try {
			return ServletActionContext.getResponse().getWriter();
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		return null;
	}

	protected String failureJSON(String returnCode, String returnMessage) {
		return returnJSON(false, returnCode, returnMessage);
	}

	protected String successJSON(String returnCode, String returnMessage) {
		return returnJSON(true, returnCode, returnMessage);
	}

	protected String successJSON(Map paramMap) {
		return returnJSON(true, paramMap);
	}
	
	

	protected String returnJSON(boolean success, Map paramMap) {
		Map returnMap = new HashMap();
		returnMap.put("success", Boolean.valueOf(success));
		returnMap.putAll(paramMap);
		return JSONObject.fromObject(returnMap).toString();
	}

	protected String returnJSON(boolean success, String returnCode,
			String returnMessage) {
		Map returnMap = new HashMap();
		returnMap.put("success", Boolean.valueOf(success));
		returnMap.put("returnCode", returnCode);
		returnMap.put("returnMessage", returnMessage);                    
		return JSONObject.fromObject(returnMap).toString();
	}

	protected String returnJSON(boolean success, String returnCode,
			String returnMessage, Object returnObject) {
		Map returnMap = new HashMap();
		returnMap.put("success", Boolean.valueOf(success));
		returnMap.put("returnCode", returnCode);
		returnMap.put("returnMessage", returnMessage);
		returnMap.put("returnObject", returnObject);
		return JSONObject.fromObject(returnMap).toString();
	}
	
	protected String returnObjJSON(Object returnObject) throws IOException{
		String json = JsonUtils.getJSONString(returnObject);
		return returnJsonString(json);
	}
	
	
	protected String returnJsonString(String json) throws IOException{
		this.getResponse().setContentType("application/json;charset=UTF-8");
		this.getResponse().setCharacterEncoding("utf-8");
		this.getResponse().setHeader("Charset", "utf-8");
		this.getResponse().getWriter().print(json);
		this.getResponse().getWriter().flush();
		return null;
	}
	protected String returnString(String json) throws IOException{
		this.getResponse().setContentType("text/html;charset=UTF-8");
		this.getResponse().setCharacterEncoding("utf-8");
		this.getResponse().setHeader("Charset", "utf-8");
		this.getResponse().getWriter().print(json);
		this.getResponse().getWriter().flush();
		return null;
	}
	protected String ReturnMes(String message)
	{
		String msg = "<script type='text/javascript'>alert('"+message+"');history.go(-1);</script>";
		try {
			return returnString(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	protected String ReturnMesAndGoTo(String message, String gotoUrl)
	{
		String msg = "<script type='text/javascript'>alert('"+message+"');location.href='"+gotoUrl+"';</script>";
		try {
			return returnString(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**朱勇添加获取request、response、session的相关方法，在action中能用到*/
	
	protected HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	protected HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}


	protected HttpSession getSession() {
		return getRequest().getSession();
	}

	protected String getParameter(String paramName) {
		return getRequest().getParameter(paramName);
	}

	protected Object getAttribute(String attrName) {
		return getRequest().getAttribute(attrName);
	}

	protected Object getSessionAttr(String attrName) {
		return getSession().getAttribute(attrName);
	}

	protected void setSessionAttr(String attrName, Object obj) {
		getSession().setAttribute(attrName, obj);
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}


	
	
}

