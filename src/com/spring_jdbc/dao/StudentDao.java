package com.spring_jdbc.dao;

import java.util.List;

import com.spring_jdbc.entities.Student;

public interface StudentDao {

	public int addStudent(Student student);
	public List<Student> findAllStudents();
}
