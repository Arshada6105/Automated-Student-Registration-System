package com.masai.UI;

import java.util.List;
import java.util.Scanner;

import com.masai.DAO.StudentDao;
import com.masai.DAO.StudentDaoImpl;
import com.masai.DAO.courseB_idDao;
import com.masai.DAO.courseB_idDaoImpl;
import com.masai.DTO.Student;
import com.masai.DTO.StudentImpl;
import com.masai.EXCEPTIONS.RecordNotfoundException;
import com.masai.EXCEPTIONS.SomethingWentWrongException;

public class StudentUi {
	
	StudentDao student;
	courseB_idDao coursebid;
	Scanner sc;
	
	public StudentUi(Scanner sc) {
		this.sc = sc;
		student=new StudentDaoImpl();	
		coursebid = new courseB_idDaoImpl();
	}
	
	public int registration() throws RecordNotfoundException {
		int bid1=0;
		System.out.println("New User Registration");
		System.out.println("Enter Name");
		String name=sc.next();
		System.out.println("Enter State");
		String add=sc.next();
		System.out.println("Enter email");
		String email=sc.next();
		System.out.println("Enter phone");
		String phone=sc.next();
		if(phone.length()!=10) {
			throw new RecordNotfoundException("phone number must contain 10 digits");
		}
		System.out.println("Enter password");
		String pass=sc.next();
		
		/**
		 * Show available batches here
		 *
		 */
		
		coursebid.showCoursebid();
		
		
		
		System.out.println("Enter the batch id from available courses");
		 int bid=sc.nextInt();
		
		
		Student stu = new StudentImpl(name, add, email, phone, pass,bid);
		
		try {
			student.addStudent(stu);
			bid1=bid;
			
		} catch (RecordNotfoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		return bid1;
	}
	
	public boolean login() {
		boolean present=false;
		System.out.println("Enter username");
		String user=sc.next();
		System.out.println("Enter password");
		String pass=sc.next();
		
		try {
			String name=student.logIn(user, pass);
			if(name!="") {
				System.out.println("hello "+name);
				present=true;
			}
		} catch (RecordNotfoundException | SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return present;
	}
	
	public void updateStudent()  {
		System.out.println("Enter Name");
		String name=sc.next();
		System.out.println("Enter State");
		String add=sc.next();
		System.out.println("Enter email");
		String email=sc.next();
		System.out.println("Enter phone");
		String phone=sc.next();
		System.out.println("Enter password");
		String pass=sc.next();
		System.out.println("Enter the batch id");
		int bid=sc.nextInt();
		Student stu = new StudentImpl(name, add, email, phone, pass,bid);
		System.out.println("Enter student id");
		int id=sc.nextInt();
		
		
		try {
			student.updateStudent(stu,id);
		} catch (RecordNotfoundException | SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getStudentLists() {
		System.out.println("All the student list are as follows");
		try {
			List<Student> stu=student.getAllStudent();
			for(Student s:stu) {
				System.out.println(s);
			}
		} catch (RecordNotfoundException | SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
