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
		$('#addStudent').click(function(){
			 window.self.location = '<%=basePath%>student/add.jsp';
		});
		$('a[name="delete"]').click(function(){
			$.ajax({
		          url: "<%=basePath%>/student/delStudent",
		          type: "POST",
		          dataType: "json",
		          data: {
		            "id": $(this).parent().attr('id')
		          },
		          async: false,
		          success: function(data) {
		            $.each(data, function(index, element) {
		              alert(data.result);
		              window.self.location = "<%=basePath%>student/listStudents";
		            });
		          },
		          error: function() {
		            alert("error");
		          }
		        });
			//alert("删除"+$(this).parent().attr('id'));
		});
		$('a[name="modify"]').click(function(){
			window.self.location = "<%=basePath%>student/modifyStudent?id="+$(this).parent().attr('id');
			//alert("修改"+$(this).parent().attr('id'));
		});
	});
</script>
</head>
<body>
<h3>学生列表</h3>
<table>
	<tr>
		<th>姓名</th>
		<th>性别</th>
		<th>年龄</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${listStudents }" var="student" >
	<tr>
		<td>${student.name }</td>
		<td>${student.sex}</td>
		<td>${student.age}</td>
		<td id="${student.id }"><a name="delete">删除</a> <br/><a name="modify" >修改</a></td>
	</tr>
	</c:forEach>
</table>
<input type="button" value="添加" id="addStudent"/>
</body>
</html>