<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>SB Admin - Start Bootstrap Template</title>
  <!-- Bootstrap core CSS-->
  <link href="../menu/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="../menu/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="../menu/css/sb-admin.css" rel="stylesheet">
</head>

<body class="bg-dark">
  <div class="container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">Login</div>
      <div class="card-body">
        <form action="" method="post" id="submitForm">
          <div class="form-group">
            <label for="exampleInputEmail1">User Name</label>
            <input class="form-control" name="name" id="exampleInputEmail1" type="text" aria-describedby="emailHelp" placeholder="User Name">
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input class="form-control" name="password" id="exampleInputPassword1" type="password" placeholder="Password">
          </div>
          <div class="form-group">
            <div class="form-check">
              <label class="form-check-label">
                <input class="form-check-input" type="checkbox"> Remember Password</label>
            </div>
          </div>
          <a class="btn btn-primary btn-block" id="loginBut">Login</a>
        </form>
        <div class="text-center">
          <a class="d-block small mt-3" href="register.html">Register an Account</a>
          <a class="d-block small" href="forgot-password.html">Forgot Password?</a>
        </div>
      </div>
    </div>
  </div>
  <!-- Bootstrap core JavaScript-->
  <script src="../menu/vendor/jquery/jquery.min.js"></script>
  <script src="../menu/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="../menu/vendor/jquery-easing/jquery.easing.min.js"></script>
  <script type="text/javascript">
  		$(function(){
			$("#loginBut").click(function(){
				$("#submitForm").attr("action", "${pageContext.request.contextPath}/login/loginpage").submit();
			});
  			
  			/*回车事件*/
  			function EnterPress(e){ //传入 event 
  				var e = e || window.event; 
  				if(e.keyCode == 13){ 
  					$("#submitForm").attr("action", "${pageContext.request.contextPath}/login/loginpage").submit();
  				} 
  			} 
  		});
  </script>
</body>

</html>
