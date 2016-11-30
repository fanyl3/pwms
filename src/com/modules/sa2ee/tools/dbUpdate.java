package com.modules.sa2ee.tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Set;

public class dbUpdate {

	// 执行更新
	public static int doUpate() {
		int oldCount = 1;
		int index = 0;
		Statement stmt = null;
		Connection conn;
		orderedProperties pro = getSqlData("dbUpdate.properties");
		conn = connectMysql();

		if (conn != null) {
			try
			{
			stmt = conn.createStatement();
			createUpdateTable(stmt);
			oldCount = getHistoryCount(stmt);
			if (oldCount < pro.size()) 
			{
					Set<Object> keys = pro.keySet();
					Iterator<Object> setIntIt = keys.iterator();
					while (setIntIt.hasNext()) 
					{
						Object obj = setIntIt.next();
						if (++index > oldCount) 
						{
							executeUpdateSql(stmt, obj, pro
									.getProperty((String) obj));
						}
					}
			}
			}catch(SQLException e)
			{
				System.out.println("execute mysql err");
				//e.printStackTrace();
			}
		}	
		else {
				System.out.println("connect mysql err");
		}
		if (stmt != null)
			try {
				System.out.println("close stmt");
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (conn != null)
			try {
				System.out.println("close conn");
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("close conn failed");
				e.printStackTrace();
			}
		return pro.size() - oldCount;
	}

	// 创建更新历史表
	private static void createUpdateTable(Statement stmt) throws SQLException {
		String sql = "CREATE TABLE IF NOT EXISTS db_update_history("
				+ "id int NOT NULL AUTO_INCREMENT ,"
				+ "COMMENT varchar( 256 ) NOT NULL ,"
				+ "update_status boolean NOT NULL, "
				+ "create_time timestamp NOT NULL DEFAULT NOW(),"
				+ "PRIMARY KEY ( id ) ) ENGINE = innodb";
		stmt.execute(sql);
	}

	private static int getHistoryCount(Statement stmt) throws SQLException {
		String sql = "select count(*) from db_update_history";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		int result = rs.getInt(1);
		rs.close();
		return result;
	}

	// 执行更新
	private static void executeUpdateSql(Statement stmt, Object key,
			String value) {
		try {
			stmt.execute(value);
			stmt.executeUpdate("insert into db_update_history set comment='"+ key + "'," + "update_status = " + true) ;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				stmt.executeUpdate("insert into db_update_history set comment='"+ key + "'," + "update_status = " + false) ;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//e.printStackTrace();
		}
		System.out.println(key + " " + value);
	}

	// 连接数据库
	private static Connection connectMysql() {
		orderedProperties pro = getSqlData("dataSource.properties");
		String password = pro.getProperty("mysql.database.password");
		String username = pro.getProperty("mysql.database.user");
		String driver = pro.getProperty("mysql.database.driver");
		String url = pro.getProperty("mysql.database.url");
		try {
			// 加载MySql的驱动类
			Class.forName(driver);
			try {
				Connection con = DriverManager.getConnection(url, username,
						password);
				return con;
			} catch (SQLException se) {
				System.out.println("数据库连接失败！");
				se.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("找不到驱动程序类 ，加载驱动失败！");
			e.printStackTrace();
		}
		return null;
	}

	// 获取配置信息
	private static orderedProperties getSqlData(String PropFile) {
		String path;
		orderedProperties pro = new orderedProperties();
		FileInputStream fis;
		try {
			path = dbUpdate.class.getClassLoader().getResource(PropFile).toURI()
					.getPath();
			fis = new FileInputStream(path);
			System.out.println(path);
			pro.load(fis);

		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			System.out.println("2-IOException");
			e.printStackTrace();
		}
		return pro;
	}
}
