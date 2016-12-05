<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%@ include file="/common/config.inc"%> 
    <title>Index</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  
  <form name="remindListForm" action="<%=path%>/user/index.action" method="post">
  用户名：
  	<input name="username">
  	<input  type="submit" value="确定">
  </form>
    This is my JSP page. <br>
    
    <a href="<%=basePath%>queue/queueList">添加</a>
  </body>
</html>
