package com.guo.school.dao;

import java.util.List;

import com.guo.school.domain.Student;

public interface StudentDao {
	public abstract List<Student> listStudents();
	public abstract int addStudent(Student student);
	public abstract int updateStudent(Student student);
	public abstract int delateStudent(int id);
	public abstract Student findStudentById(int id);
}
