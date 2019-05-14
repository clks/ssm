package com.guo.school.service;

import java.util.List;

import com.guo.school.domain.Student;

public interface StudentService {
	public abstract List<Student> listStudents();
	public abstract int addStudent(Student student);
	public abstract int updateStudent(Student student) throws Exception;
	public abstract int delateStudent(int id);
	public abstract Student findStudentById(int id);

}
