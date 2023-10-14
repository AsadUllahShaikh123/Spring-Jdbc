package com.spring_jdbc.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring_jdbc.config.AppConfig;
import com.spring_jdbc.dao.StudentDao;
import com.spring_jdbc.entities.Student;

public class Main {

	public static void main(String [] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		StudentDao dao = context.getBean("dao",StudentDao.class);
			
		// =========  Insertion Operation ====== 
//		Student student = context.getBean("student",Student.class);
//		student.setName("Asadullah");
//		student.setAddress("Karachi");
//		
//		int added = dao.addStudent(student);
//		System.out.println("Data inserted ... " + added);
		
		
		List<Student> list = dao.findAllStudents();
		for(Student student : list) {
			System.out.println(student);
		}
	}
}
