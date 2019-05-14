<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加用户</title>
<script type="text/javascript" src="<%=basePath%>js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(function(){
		$('#cancel').click(function(){
			window.self.location = '<%=basePath%>index.jsp';
		});
	});
	
</script>
</head>
<body>
	<form action="user/add" method="post">
	用户名：<input type="text" name="username"></input><br/>
	密码：<input type="text" name="password"></input><br/>
	<input type="submit" value="保存"></input>
	<input type="button" id="cancel" value="取消"/>
	</form>
</body>
</html>