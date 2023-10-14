package com.spring_jdbc.main;

import java.util.ArrayList;
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

//		 ==== Get All Students =========
//		System.out.println("Hello from Debugging....");
//		List<Student> list = dao.findAllStudents();
//		for(Student student : list) {
//			System.out.println(student);
//		}
		
		// ==== Get Specific Student ==== 
//		
//		Student student = dao.findStudentByRollNo(5);
//		System.out.print(student);
		
	   // === Delete the Specific Record === 
//		
//		boolean deleted = dao.deleteRecord(5);
//		System.out.println("Record Deleted Successfully ... " + deleted);

		
		// === Delete Record By Student Name and Address 
		
//		int deletedRecords = dao.deleteRecordByStudentNameAndAddress("Asadullah", "karachi");
//		
//		System.out.println("Records Deleted successfully" + deletedRecords);
		
//		=== Adding Mulitple Students ==== 
		
		
		
		Student std1 = new Student("Asad","moro");
		Student std2 = new Student("Azhar","karachi");
		Student std3 = new Student("Safdar","Hyderabad");
		Student std4 = new Student("Mazhar","Islamabad");
		
		List<Student> list = new ArrayList<Student>();
		list.add(std1);
		list.add(std2);
		list.add(std3);
		list.add(std4);
		
		int rowsAdded = dao.addMultipleStudents(list);
		System.out.println("Rows Added using Batch Insert Operation .. " + rowsAdded);
		
		
	}
}
