package com.guo.school.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.guo.school.dao.StudentDao;
import com.guo.school.dao.UserDao;
import com.guo.school.domain.User;

/**
 * 用户控制器
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private UserDao userDao;
    private StudentDao studentDao;
    
    public StudentDao getStudentDao() {
		return studentDao;
	}
    @Resource
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	private List<User> listUser;

    public List<User> getListUser() {
		return listUser;
	}

	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}

	@RequestMapping("/view")
    public String view() {
        return "main/login";
    }

//    @RequestMapping("/indexview")
//    public String index() {
//        return "main/index";
//    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(User model, HttpSession session) {
        User user = userDao.findByUsername(model.getUsername());

        if (user == null || !user.getPassword().equals(model.getPassword())) {
            return new ModelAndView("redirect:/login.jsp");
        } else {
            session.setAttribute("user", user);
            listUser=userDao.listUsers();
            ModelAndView mav = new ModelAndView();
            mav.addObject("listStudents",studentDao.listStudents());
            mav.setViewName("student/listStudent");
            return mav;
        }
    }
        @RequestMapping(value = "/add", method = RequestMethod.POST)
        public ModelAndView add(User model, HttpSession session) {
            

            if (model == null || "".equals(model.getUsername()) 
            		|| null ==model.getUsername()) {
                return new ModelAndView("redirect:/add.jsp");
            } else {
                ModelAndView mav = new ModelAndView();
                Integer count=userDao.addUser(model);
                listUser=userDao.listUsers();
                mav.addObject("listUser",listUser);
                mav.setViewName("index");
                return mav;
            }
    }
}