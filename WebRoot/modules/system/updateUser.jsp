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
<script type="text/javascript">
function subform(){
	alert('修改成功');
	var location = (window.location+'').split('/'); 
	var basePath= location[0]+'//'+location[2]+'/'+location[3]; 
    var form = document.getElementById('myForm');//获取表单dom
    form.action=basePath+'/user/updateUser.action';//重新设置提交url
    form.submit();//提交表单
    parent.window.location.reload(); 
    window.close();//关闭窗口
 }
</script>
</head>

<body class="withvernav">
<div class="bodywrapper">
    <div class="topheader">
        <div class="left">
            <h1 class="logo">Ama.<span>Admin</span></h1>
            
            <br clear="all" />
            
        </div><!--left-->
        
        
    </div><!--topheader-->
    
    
        
    <div class="centercontent">
    
        <div class="pageheader notab">
            <h1 class="pagetitle">用户管理</h1>
            <span class="pagedesc">账号管理页面</span>
            
        </div><!--pageheader-->
        
        <div id="contentwrapper" class="contentwrapper">
                
               <div class="contenttitle2">
                        <h3>Form Style 2</h3>
                    </div><!--contenttitle-->
                    
					<form class="stdform" id="myForm" method="post" action="<%=basePath%>user/updateUser.action"'>
                    	<p>
                        	<label>工号</label>
                            <span class="field"><input type="text" name="user.staffId" id="staffId" value="${user.staffId }" class="longinput" /></span>
                        </p>
                    	<p>
                        	<label>账号名称</label>
                            <span class="field"><input type="text" name="user.userName" id="userName" value="${user.userName }" class="longinput" /></span>
                        </p>
                        
                        <p>
                        	<label>姓名</label>
                            <span class="field"><input type="text" name="user.name" id="name" value="${user.name }" class="longinput" /></span>
                        </p>
                        <p>
                        	<label>默认密码</label>
                            <span class="field"><input type="text" name="user.password" value="${user.password }" id="password" class="longinput" value='123456'/></span>
                        </p>
                        <p>
                        	<label>手机</label>
                            <span class="field"><input type="text" name="user.phone" value="${user.phone }" id="phone" class="longinput" /></span>
                        </p>
                        <p>
                        	<label>Email</label>
                            <span class="field"><input type="text" name="user.email" value="${ user.email}" id="email" class="longinput" /></span>
                        </p>
                        <input type="hidden" name="user.id" value="${ user.id}"/>
                        <p>
                        	<label>性别</label>
                            <span class="field"><select name="user.sex" id="sex">
                                <option value="0" ${0 eq user.sex ? 'selected=\"selected\"' : ''}>男</option>
                                <option value="1" ${1 eq user.sex ? 'selected=\"selected\"' : ''}>女</option>
                            </select></span>
                        </p>
                        
                        
                        <p class="stdformbutton">
                        	<button class="submit radius2" onclick="subform();">提交</button>
                            <input type="reset" class="reset radius2" value="重置" />
                        </p>
                    </form>
					
                    <br />

            </div><!--subcontent-->
            
           

                
          <br /><br />
                
         
        
        </div><!--contentwrapper-->
        
	</div><!-- centercontent -->
    
    
</div><!--bodywrapper-->

 
</body>
</html>
