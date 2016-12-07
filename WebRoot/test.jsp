<html>
<head>
    <%@ include file="/common/config.inc"%> 
    <%@ page contentType="textml; charset=UTF-8"%>
	<meta http-equiv="content-type" content="text/html;charset=utf-8"/>
    <title>Login</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
 </head>
<body>
  <form action="<%=basePath%>login" method="post">
   用户名：<input type="text" name="staffName"> <br/>
   密 码：<input type="text" name="passWord"> <br/>
    <input type="submit" value="登陆"/>
    </form>
  </body>
 </html>