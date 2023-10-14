package com.spring_jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
		
		RowMapper<Student> rowMapper = getRowMapper();
		
//		List<Student> list = jdbc.query(sql,rowMapper);
		
		// using BeanPropertyRowMapper;
		
		List<Student> list = jdbc.query(sql,new BeanPropertyRowMapper<Student>(Student.class));

		
		
		return list;
	}
	private RowMapper<Student> getRowMapper() {
		RowMapper<Student> rowMapper = new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student();
				
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setAddress(rs.getString("address"));
				return student;
			}
			
		};
		return rowMapper;
	}
	@Override
	public Student findStudentByRollNo(int id) {
		String sql = "select * from student where id = ?";
		
		Student student = jdbc.queryForObject(sql,new BeanPropertyRowMapper<Student>(Student.class),id);
		
		return student;
	}
	@Override
	public boolean deleteRecord(int id) {
	
		String sql = "delete from student where id = ? ";
		int rowsDeleted = jdbc.update(sql,id);
		return rowsDeleted == 1;
	}

}
