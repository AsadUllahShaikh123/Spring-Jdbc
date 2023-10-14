package com.spring_jdbc.dao;

import java.util.List;

import com.spring_jdbc.entities.Student;

public interface StudentDao {

	public int addStudent(Student student);
	public List<Student> findAllStudents();
	public Student findStudentByRollNo(int id);
	public boolean deleteRecord(int id);
	public int deleteRecordByStudentNameAndAddress(String name,String address);
	public int addMultipleStudents(List<Student> students);

}
