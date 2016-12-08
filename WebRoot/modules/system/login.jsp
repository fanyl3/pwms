<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ include file="/common/config.inc"%>
<meta http-equiv="Content-Type" content="text/html"; charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>登录页面</title>
<link rel="stylesheet" href="<%=basePath%>ui/css/style.default.css" type="text/css" />
<script type="text/javascript" src="<%=basePath%>ui/js/plugins/jquery-1.7.min.js"></script>
<script type="text/javascript" src="<%=basePath%>ui/js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="<%=basePath%>ui/js/plugins/jquery.cookie.js"></script>
<script type="text/javascript" src="<%=basePath%>ui/js/plugins/jquery.uniform.min.js"></script>
<script type="text/javascript" src="<%=basePath%>ui/js/custom/general.js"></script>
<script type="text/javascript" src="<%=basePath%>ui/js/custom/index.js"></script>
<!--[if IE 9]>
    <link rel="stylesheet" media="screen" href="css/style.ie9.css"/>
<![endif]-->
<!--[if IE 8]>
    <link rel="stylesheet" media="screen" href="css/style.ie8.css"/>
<![endif]-->
<!--[if lt IE 9]>
	<script src="js/plugins/css3-mediaqueries.js"></script>
<![endif]-->
</head>

<body class="loginpage">
	<div class="loginbox">
    	<div class="loginboxinner">
        	
            <div class="logo">
            	<h1 class="logo">Ama.<span>Admin</span></h1>
				<span class="slogan">后台管理系统</span>
            </div><!--logo-->
            
             <div class="nousername">
             	<div id="actionmsg" class="loginmsg" style="color:red"><s:property value="errmsg" /></div>
				<div id="jsmsg" class="loginmsg" style="color:red"></div>
            </div><!--nousername-->
            
            
            <form id="login" action="<%=basePath%>login" method="post">
            	            	
                <div class="username">
                	<div class="usernameinner">
                    	<input type="text" name="username" id="username" />
                    </div>
                </div>
                
                <div class="password">
                	<div class="passwordinner">
                    	<input type="password" name="password" id="password" />
                    </div>
                </div>
                
                <button type="submit">登录</button>
                
                <div class="keep"><input type="checkbox" /> 记住密码</div>
            
            </form>
            
        </div><!--loginboxinner-->
    </div><!--loginbox-->


</body>
</html>
