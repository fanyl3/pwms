
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:set var="context"  value="<%=path%>"></c:set>
<c:set var="basePath"  value="<%=basePath%>"></c:set>
<c:set var="siteversion" value="ver-32413"></c:set>
<script type="text/javascript">
	var scriptGlobal ={
		appRoot: "<%=path%>",
		hostUrl: "<%=basePath%>",
	};
	</script>