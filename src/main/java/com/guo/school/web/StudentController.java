package com.guo.school.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.support.json.JSONUtils;
import com.guo.school.dao.StudentDao;
import com.guo.school.domain.Student;
import com.guo.school.service.impl.StudentServiceImpl;
import com.mysql.jdbc.StringUtils;

/**
 * 
 * @author acer
 * student controller 
 */
@Controller
@RequestMapping(value = "/student")
public class StudentController {
	public StudentDao studentDao;
	public StudentServiceImpl studentServiceImpl;
	

	public StudentServiceImpl getStudentServiceImpl() {
		return studentServiceImpl;
	}
	@Resource
	public void setStudentServiceImpl(StudentServiceImpl studentServiceImpl) {
		this.studentServiceImpl = studentServiceImpl;
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}
	
	/*
	 * @InitBinder protected void initBinder(WebDataBinder binder) {
	 * binder.registerCustomEditor(Integer.class,"sex", new IntegerEditor());
	 * binder.registerCustomEditor(Integer.class,"age", new IntegerEditor()); }
	 */
	@Resource
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	@RequestMapping(value="listStudents")
	public ModelAndView listStudents() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("listStudents", studentServiceImpl.listStudents());
		mav.setViewName("student/listStudent");
		return mav;
	}
	
	@RequestMapping(value="addStudent")
	public ModelAndView addStudent(Student student) {
		ModelAndView mav=new ModelAndView();
		boolean i=StringUtils.isNullOrEmpty(student.getName()) || student.getAge()==0;
		if(i) {
			mav.addObject("student", student);
			mav.setViewName("student/add");
		}else {
			Student s=studentServiceImpl.findStudentById(student.getId());
			if(s!=null) {
				student.setUpdateTime(new Date());
				try {
					studentServiceImpl.updateStudent(student);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				student.setCreateTime(new Date());
				student.setUpdateTime(new Date());
				int result=studentServiceImpl.addStudent(student);
			}
			mav.addObject("listStudents", studentDao.listStudents());
			mav.setViewName("student/listStudent");
		}
		
		return mav;
	}
	@RequestMapping(value="modifyStudent")
	public ModelAndView modifyStudent(Student student) {
		ModelAndView mav=new ModelAndView();
		student=studentServiceImpl.findStudentById(student.getId());
		if(student!=null) {
			mav.addObject("student", student);
			mav.setViewName("student/add");
		}else {
			int result=studentServiceImpl.addStudent(student);
			mav.addObject("listStudents", studentDao.listStudents());
			mav.setViewName("student/listStudent");
		}
		
		return mav;
	}
	
	@RequestMapping(value="delStudent")
	public void delStudent(Integer id,HttpServletResponse response) {
		//设置页面数据
	    Map<String,Object> jsonMap = new HashMap<String,Object>();
	    
	     
	    try {
	    	int result=studentServiceImpl.delateStudent(id);
	    	if(result>0) {
	    		jsonMap.put("result","删除成功");
	    	}else {
	    		jsonMap.put("result","删除失败或用户不存在");
	    	}
	        //设置页面不缓存
	        response.setContentType("application/json");
	        response.setHeader("Pragma", "No-cache");
	        response.setHeader("Cache-Control", "no-cache");
	        response.setCharacterEncoding("UTF-8");
	        PrintWriter out= null;
	        out = response.getWriter();
	        out.print(JSONUtils.toJSONString(jsonMap));
	        out.flush();
	        out.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
