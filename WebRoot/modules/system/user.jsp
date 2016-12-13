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
                            <th class="head0">权限</th>
                            <th class="head0">操作</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr class="gradeX">
                            <td>1</td>
                            <td>A</td>
                            <td>B</td>
                            <td class="center">123456789</td>
                            <td class="center">123456789@qq.com</td>
                            <td class="center">男</td>
                            <td class="center">普通员工</td>
                            <td class="center"><button>修改</button>  <button>删除</button></td>
                        </tr>
                        <tr class="gradeX">
                            <td>2</td>
                            <td>A</td>
                            <td>B</td>
                            <td class="center">123456789</td>
                            <td class="center">123456789@qq.com</td>
                            <td class="center">男</td>
                            <td class="center">普通员工</td>
                            <td class="center"><button>修改</button> <button>删除</button></td>
                        </tr>
                         <tr class="gradeX">
                            <td>3</td>
                            <td>A</td>
                            <td>B</td>
                            <td class="center">123456789</td>
                            <td class="center">123456789@qq.com</td>
                            <td class="center">男</td>
                            <td class="center">普通员工</td>
                            <td class="center"><button>修改</button> <button>删除</button></td>
                        </tr>
                         <tr class="gradeX">
                            <td>4</td>
                            <td>A</td>
                            <td>B</td>
                            <td class="center">123456789</td>
                            <td class="center">123456789@qq.com</td>
                            <td class="center">男</td>
                            <td class="center">普通员工</td>
                            <td class="center"><button>修改</button> <button>删除</button></td>
                        </tr>
                         <tr class="gradeX">
                            <td>5</td>
                            <td>A</td>
                            <td>B</td>
                            <td class="center">123456789</td>
                            <td class="center">123456789@qq.com</td>
                            <td class="center">男</td>
                            <td class="center">普通员工</td>
                            <td class="center"><button>修改</button> <button>删除</button></td>
                        </tr>
                         <tr class="gradeX">
                            <td>6</td>
                            <td>A</td>
                            <td>B</td>
                            <td class="center">123456789</td>
                            <td class="center">123456789@qq.com</td>
                            <td class="center">男</td>
                            <td class="center">普通员工</td>
                            <td class="center"><button>修改</button> <button>删除</button></td>
                        </tr>
                         <tr class="gradeX">
                            <td>7</td>
                            <td>A</td>
                            <td>B</td>
                            <td class="center">123456789</td>
                            <td class="center">123456789@qq.com</td>
                            <td class="center">男</td>
                            <td class="center">普通员工</td>
                            <td class="center"><button>修改</button> <button>删除</button></td>
                        </tr>
                         <tr class="gradeX">
                            <td>8</td>
                            <td>A</td>
                            <td>B</td>
                            <td class="center">123456789</td>
                            <td class="center">123456789@qq.com</td>
                            <td class="center">男</td>
                            <td class="center">普通员工</td>
                            <td class="center"><button>修改</button> <button>删除</button></td>
                        </tr>
                         <tr class="gradeX">
                            <td>9</td>
                            <td>A</td>
                            <td>B</td>
                            <td class="center">123456789</td>
                            <td class="center">123456789@qq.com</td>
                            <td class="center">男</td>
                            <td class="center">普通员工</td>
                            <td class="center"><button>修改</button> <button>删除</button></td>
                        </tr>
                        <tr class="gradeX">
                            <td>99</td>
                            <td>A</td>
                            <td>B</td>
                            <td class="center">123456789</td>
                            <td class="center">123456789@qq.com</td>
                            <td class="center">男</td>
                            <td class="center">普通员工</td>
                            <td class="center"><button>修改</button> <button>删除</button></td>
                        </tr>
                        <tr class="gradeX">
                            <td>99</td>
                            <td>A</td>
                            <td>B</td>
                            <td class="center">123456789</td>
                            <td class="center">123456789@qq.com</td>
                            <td class="center">男</td>
                            <td class="center">普通员工</td>
                            <td class="center"><button>修改</button> <button>删除</button></td>
                        </tr>
 
                    </tbody>
                </table>
                
          <br /><br />
                
         
        
        </div><!--contentwrapper-->
        
	</div><!-- centercontent -->
    
    
</div><!--bodywrapper-->

</body>
</html>
