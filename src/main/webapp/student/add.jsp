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
<link rel="stylesheet" href="<%=basePath%>css/core.css"></link>
<script type="text/javascript" src="<%=basePath%>js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.validate.js"></script>
<script type="text/javascript">
	function rexNumber(objRex, showTxt){
		var numRex=/^\+?[1-9][0-9]*$/;
		if(!numRex.test(objRex.val())){
			objRex.next('div').remove();
			objRex.after("<div>"+showTxt+"</div>")
			return false;
		}else{
			return true;
		}
	}
	$(function(){
		$('#cancel').click(function(){
			window.self.location = '<%=basePath%>student/listStudents';
		});
		$('input[name=name]').focus();
		
		$('input[name=save]').click(function(){
			var result=rexNumber($('input[name=sex]'),'性别错误');
			result=rexNumber($('input[name=age]'), "年龄错误") && result;
			
			return result;
		});
		
	});
	
</script>
</head>
<body>
	<h1>添加学生</h1>
	<form action="addStudent" method="post">
	<input type="hidden" name="id" value="${student.id }"></input>
	姓名：<input type="text" name="name" value="${student.name }" ></input><br/>
	性别：<input type="text" name="sex" value="${student.sex }"></input><br/>
	年龄<input type="text" name="age" value="${student.age }"></input><br/>
	<input type="submit" value="保存" name="save"></input>
	<input type="button" id="cancel" value="取消"/>
	</form>
</body>
</html>