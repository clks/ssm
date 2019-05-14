package com.guo.school.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.guo.school.dao.StudentDao;
import com.guo.school.domain.Student;
import com.guo.school.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
	private StudentDao studentDao;
	
	public StudentDao getStudentDao() {
		return studentDao;
	}
	@Resource
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public List<Student> listStudents() {
		// TODO Auto-generated method stub
		return studentDao.listStudents();
	}

	@Override
	public int addStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDao.addStudent(student);
	}

	@Override
	public int updateStudent(Student student) throws Exception {
		// TODO Auto-generated method stub
		
		return studentDao.updateStudent(student);
	}

	@Override
	public int delateStudent(int id) {
		// TODO Auto-generated method stub
		return studentDao.delateStudent(id);
	}

	@Override
	public Student findStudentById(int id) {
		// TODO Auto-generated method stub
		return studentDao.findStudentById(id);
	}

}
