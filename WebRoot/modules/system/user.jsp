<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ include file="/common/config.inc"%>
<meta http-equiv="Content-Type" content="text/html"; charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>账号管理</title>
<link rel="stylesheet" href="<%=basePath%>ui/css/style.default.css" type="text/css" />
<script type="text/javascript" src="<%=basePath%>ui/js/plugins/jquery-1.7.min.js"></script>
<script type="text/javascript" src="<%=basePath%>ui/js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="<%=basePath%>ui/js/plugins/jquery.cookie.js"></script>
<script type="text/javascript" src="<%=basePath%>ui/js/plugins/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=basePath%>ui/js/plugins/jquery.uniform.min.js"></script>
<script type="text/javascript" src="<%=basePath%>ui/js/custom/general.js"></script>
<script type="text/javascript" src="<%=basePath%>ui/js/custom/tables.js"></script>
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

<body class="withvernav">
<div class="bodywrapper">
    <div class="topheader">
        <div class="left">
            <h1 class="logo">Ama.<span>Admin</span></h1>
            <span class="slogan">搜索</span>
            <div class="search">
            	<form action="" method="post">
                	<input type="text" name="keyword" id="keyword" value="Enter keyword(s)" />
                    <button class="submitbutton"></button>
                </form>
            </div><!--search-->
            
            <br clear="all" />
            
        </div><!--left-->
        
        <div class="right">
        	<!--<div class="notification">
                <a class="count" href="notifications.html"><span>9</span></a>
        	</div>
			-->
            <div class="userinfo">
            	<img src="<%=basePath%>ui/images/thumbs/avatar.png" alt="" />
                <span>Juan Dela Cruz</span>
            </div><!--userinfo-->
            
            <div class="userinfodrop">            	<div class="avatar">
                	<a href=""><img src="<%=basePath%>ui/images/thumbs/avatarbig.png" alt="" /></a>
                    <div class="changetheme">
                    	Change theme: <br />
                    	<a class="default"></a>
                        <a class="blueline"></a>
                        <a class="greenline"></a>
                        <a class="contrast"></a>
                        <a class="custombg"></a>
                    </div>
                </div><!--avatar-->
<div class="userdata">
                	<h4>Juan Dela Cruz</h4>
                    <span class="email">youremail@yourdomain.com</span>
                    <ul>
                    	<li><a href="editprofile.html">Edit Profile</a></li>
                        <li><a href="accountsettings.html">Account Settings</a></li>
                        <li><a href="help.html">Help</a></li>
                        <li><a href="index.html">Sign Out</a></li>
                    </ul>
                </div><!--userdata-->
            </div><!--userinfodrop-->
        </div><!--right-->
    </div><!--topheader-->
    
    <%@ include file="/common/menu.jsp"%>
        
    <div class="centercontent tables">
    
        <div class="pageheader notab">
            <h1 class="pagetitle">用户管理</h1>
            <span class="pagedesc">账号管理页面</span>
            
        </div><!--pageheader-->
        
        <div id="contentwrapper" class="contentwrapper">
                
                <div class="contenttitle2">
                	<h3>账号管理列表</h3>
                </div><!--contenttitle-->
                <div class="tableoptions">
                    <button class="radius3"  onclick="window.open('<%=basePath%>modules/system/addUser.jsp')">创建账号</button>
                </div>
                <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="dyntable">
                    <colgroup>
                        <col class="con0" />
                        <col class="con1" />
                        <col class="con0" />
                        <col class="con1" />
                        <col class="con0" />
                        <col class="con1" />
                        <col class="con0" />
                    </colgroup>
                    <thead>
                        <tr>
                            <th class="head0">工号</th>
                            <th class="head1">用户名</th>
                            <th class="head0">真实姓名</th>
                            <th class="head1">电话</th>
                            <th class="head0">邮箱</th>
                            <th class="head1">性别</th>
                            <th class="head0">操作</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<c:forEach items="${users}" var="row" varStatus="vs">
	                        <tr class="gradeX">
	                            <td>${row.staffId}</td>
	                            <td>${row.userName}</td>
	                            <td>${row.name}</td>
	                            <td class="center">${row.phone}</td>
	                            <td class="center">${row.email}</td>
	                            <td class="center">${row.sex}</td>
	                            <td class="center")"><button  onclick="window.open('<%=basePath%>user/updatePage?id=${row.id}')">修改</button>  <button onclick="doDelete('${row.id}')">删除</button></td>
	                        </tr>
                        </c:forEach>

                    </tbody>
                </table>
                
          <br /><br />
                
         
        
        </div><!--contentwrapper-->
        
	</div><!-- centercontent -->
    
    
</div><!--bodywrapper-->
<script>
 	function doDelete(id)
        {
 		var location = (window.location+'').split('/'); 
		 
 		var basePath= location[0]+'//'+location[2]+'/'+location[3]; 
 		jQuery.ajax({  
        	    	type:'post',  
        	    	url:basePath+'/user/deleteUser',
        	    	data:{'id':id},  
        	    	cache:false,  
        	    	dataType:'json',  
        	    	success:function(){
        	    		alert('删除成功');
        	    		window.location.reload();
        	    	},  
        	    	error:function(){alert('删除成功');window.location.reload();}  
        	     }); 
        }
 	function doUpdate(id)
    {

    	    $.ajax({  
    	    	type:'post',  
    	    	url:basePath+'user/updateUser.action',
    	    	data:{'id':id}, 
    	    	cache:false,  
    	    	dataType:'json',  
    	    	success:function(){
    	    		alert('更新成功');
    	    		window.close();
    	    	},  
    	    	error:function(){alert('更新成功');window.close();}  
    	     }); 
    }
</script>

</body>
</html>
