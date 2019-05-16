package com.guo.school.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.guo.school.domain.User;
import com.guo.school.service.RoleService;
import com.guo.school.service.UserService;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
    private static final Log log = LogFactory.getLog(LoginController.class);
	 	@Autowired
	    UserService userService;
	    
	    @Autowired
	    RoleService roleService;
	    
	    @RequestMapping(value = "loginpage",method = RequestMethod.GET)
	    public String getLogin(){
	        return "/login/login";
	    }
	    
	    @RequestMapping(value = "loginpage",method = RequestMethod.POST)
	    public String login(HttpServletRequest request, HttpServletResponse response, User user, Model model){
	        if(user.getName() == null || user.getPassword() == null){
	            return "login/fail";
	        }
	        
	        //开始登陆流程
	        try {
	            Subject subject = SecurityUtils.getSubject();
	            UsernamePasswordToken token = new UsernamePasswordToken(user.getName(),user.getPassword());
	            subject.login(token);
	            log.info("登陆成功!");
	            log.info(subject.isAuthenticated());
	    
//	            User user1 = userService.getUserByName(user.getName());
//	            Role role = roleService.getRoleById(user1.getRole());
//	            log.info("user role's permission : " + role.getPermission());
	        }
	        catch (Exception e){
	            e.printStackTrace();
	            request.setAttribute("errorInfo", e.getMessage());
	            return "login/fail";
	        }
	        return "redirect:/menu/dashboard";
	    }
	    
	    @RequestMapping(value = "fail",method = RequestMethod.GET)
	    public String logFail(){
	        return "login/fail";
	    }
	    
	    @RequestMapping(value = "permissionfail",method = RequestMethod.GET)
	    public String permissionFail(){
	        return "login/permissionFail";
	    }
	    
		/**
		 * 登出
		 * 
		 * @param request
		 * @param response
		 */
		@RequestMapping("/logout")
		public void onLogout(HttpServletRequest request, HttpServletResponse response) {
			log.info("退出登录");
			Subject currentUser = SecurityUtils.getSubject();
			currentUser.logout();
		}
		
}
