<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<footer class="sticky-footer">
      <div class="container">
        <div class="text-center">
          <small>Copyright © Your Website 2017 / More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></small>
        </div>
      </div>
    </footer>
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fa fa-angle-up"></i>
    </a>
    <!-- Logout Modal-->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
            <a class="btn btn-primary" onclick="logout()">Logout</a>
          </div>
        </div>
      </div>
    </div>
    <script type="text/javascript">
    /**
     * 登出
     */
    function logout() {
   		$.ajax({
   			// 提交数据的类型 POST GET
   			type : "POST",
   			// 提交的网址
   			url : "../login/logout",
   			//datatype : "json",// "xml", "html", "script", "json", "jsonp", "text".
   			// 成功返回之后调用的函数
   			success : function(data) {
   				window.location.href="../login/loginpage";
   			},
   			error : function(data) {
   				console.log(data);
   			}
   		});
    }
    </script>