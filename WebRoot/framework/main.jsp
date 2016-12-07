<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@ include file="/common/config.inc"%> 
  <title>About</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link href="<%=basePath%>css/styleBody.css" rel="stylesheet" type="text/css"  media="all" />
 <!--  <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'> -->
  <script type="text/javascript" src="<%=basePath%>js/jquery-1.9.0.min.js"></script>
  <script type="text/javascript" src="<%=basePath%>js/menu.js"></script> 
  <script>
  function changeSrc(){
  	document.getElementById("ifid").src = "../welcome.jsp";
  }
  </script>
 </head>
<body>
	<!----start-header----->
     <div class="header_img">
	    <img src="<%=basePath%>images/header_img.jpg" alt="" style="height:200px;width:100%;" />
         <div style="text-align:center;">
         <img src="<%=basePath%>images/kuang.jpg" alt="" style="height:150px;width:400px;position:absolute;top:50px;" />
         </div>
         
         <div class="wrap">
	        <div class="header">	        	
	        		<div class="logo">
                  	  <a href="#"><img src="<%=basePath%>images/logo.png" alt=""></a>
                  </div>
	      	       <div class="menu">
				      <nav class="clearfix">
						<ul class="clearfix">
							      <li><a href="#">首页</a></li>
								  <li class="active" onclick=changeSrc()><a>用户管理</a></li>
								  <li><a href="services.jsp">餐厅管理</a></li>
								  <li><a href="Price.jsp">排队管理</a></li>
								  <li><a href="contact.jsp">帮助</a></li>	
						 </ul>
						<a href="#" id="pull">菜单</a>
					  </nav>
                  </div>                 
             </div>
          </div>
       </div>
   <!----End-header----->
   		 <!---start-content---->
	<iframe id="ifid" src="welcome.jsp" ></iframe>

	
</body>
</html>

