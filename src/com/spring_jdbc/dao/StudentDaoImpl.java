package com.spring_jdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.spring_jdbc.entities.Student;

@Component(value="dao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbc;
	@Override
	public int addStudent(Student student) {
		
		String sql = "insert into student(name,address) values(?,?)";
		Object [] values = {student.getName(),student.getAddress()};
		int success = jdbc.update(sql,values);
		return success;
	}

}
