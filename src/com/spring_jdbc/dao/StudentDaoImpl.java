package com.spring_jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
	@Override
	public List<Student> findAllStudents() {

		String sql = "select * from student";
		
		RowMapper<Student> rowMapper = new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student();
				
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setAddress(rs.getString("address"));
				System.out.println("Row Number : " + rowNum);
				return student;
			}
			
		};
		
		List<Student> list = jdbc.query(sql,rowMapper);
		
		return list;
	}

}
