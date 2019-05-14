<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<title>主页</title>
<script type="text/javascript" src="<%=basePath%>js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(function(){
		$('#addUser').click(function(){
			 window.self.location = '<%=basePath%>add.jsp';
		});
	});
</script>
</head>
<body>
<h3>欢迎，${user.username } </h3>
<table>
	<tr>
		<th>姓名</th>
		<th>密码</th>
	</tr>
	<c:forEach items="${listUser }" var="userl" >
	<tr>
		<td>${userl.username }</td>
		<td>${userl.password}</td>
	</tr>
	</c:forEach>
</table>
<input type="button" value="添加" id="addUser"/>
</body>
</html>