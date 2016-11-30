package com.modules.sa2ee.tools;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;

import com.common.cache.Cache;
import com.common.util.JsonParser;

public class preLoader extends HttpServlet {
	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	private static final long serialVersionUID = 1L;
	// private SystemParamServicesImpl sysParamService;
	//private static WebApplicationContext springContext;
	//private ServletContext context;

	public void init() throws ServletException {
		System.out.println("db_update_count:" + dbUpdate.doUpate());
		System.out.println("init jsonparser:");
		JsonParser.getInstance();
		System.out.println("start cache:");
		//JsonParser.dotest();
		startCache();
		//doPrint(Cache.zrangeWithScores("testz", 0, -1));
	}
	
	private static void doPrint(Object str)
	{
		System.out.println(str);
	}

	/**
	 * Constructor of the object.
	 */
	public preLoader() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
	
	private static void startCache()
	{
		String path;
		Properties pro = new Properties();
		FileInputStream fis;
		try {
			path = Cache.class.getClassLoader().getResource("cache.properties").toURI()
					.getPath();
			fis = new FileInputStream(path);
			pro.load(fis);
			if (Boolean.parseBoolean(pro.getProperty("cache_enable")))
			{
				Cache.start(pro);
			}
			else
			{
				System.out.println("cache disable!!!");
			}

		} 
		catch (Exception e) {
			System.out.println("Exception");
			e.printStackTrace();
		}
	}
}
