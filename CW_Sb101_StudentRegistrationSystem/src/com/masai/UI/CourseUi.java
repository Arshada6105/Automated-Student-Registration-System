package com.masai.UI;

import java.util.List;
import java.util.Scanner;

import com.masai.DAO.CourseDao;
import com.masai.DAO.CourseDaoImpl;
import com.masai.DAO.CourseIdCnameBidDao;
import com.masai.DAO.CourseIdCnameBidDaoImpl;
import com.masai.DAO.Course_Id_nameDao;
import com.masai.DAO.Course_Id_nameDaoImpl;
import com.masai.DAO.courseB_idDao;
import com.masai.DAO.courseB_idDaoImpl;
import com.masai.DTO.Batch;
import com.masai.DTO.BatchImpl;
import com.masai.DTO.Course;
import com.masai.DTO.CourseImpl;
import com.masai.DTO.Course_Id_name;
import com.masai.EXCEPTIONS.RecordNotfoundException;
import com.masai.EXCEPTIONS.SomethingWentWrongException;

public class CourseUi {
	private CourseDao course;
	private Course_Id_nameDao cid;
	private courseB_idDao cbid;
	private CourseIdCnameBidDao ccid;
	private Scanner sc;
	public CourseUi(Scanner sc) {
		course = new CourseDaoImpl();
		cid = new Course_Id_nameDaoImpl();
		cbid = new courseB_idDaoImpl();
		ccid = new CourseIdCnameBidDaoImpl();
		this.sc = sc;
	}
	
	public void addCourse() {
		
		
		System.out.println("Availale course details");
		try {
			cid.showAllCourseIdName();
		} catch (RecordNotfoundException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1);
		}
		
		
		System.out.println("enter couse id");
		int num = sc.nextInt();
		System.out.println("Enter the course Name");
		String name = sc.next();
		System.out.println("Enter the course fee");
		int fee = sc.nextInt();
		Course crse = new CourseImpl(num, name, fee);
		
		try {
			course.addNewCourse(crse);
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateCourse() {
		
		System.out.println("Availale course details");
		try {
			cid.showAllCourseIdName();
		} catch (RecordNotfoundException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1);
		}
		
		System.out.println("Enter the course id");
		int id=sc.nextInt();
		System.out.println("Enter the amount you want to increase in cousrse fee");
		int value=sc.nextInt();
		
		try {
			course.upDateCourseFee(id, value);
			
		} catch (RecordNotfoundException | SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
	
	public void deleteCourse() {
		
		System.out.println("Availale course details");
		try {
			cid.showAllCourseIdName();
		} catch (RecordNotfoundException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1);
		}
		
		System.out.println("Enter the course id which you want to delete");
		int id=sc.nextInt();
		try {
			course.deleteCourse(id);
		} catch (RecordNotfoundException | SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void courseinfo() {
		System.out.println("Availale course details");
		try {
			cid.showAllCourseIdName();
		} catch (RecordNotfoundException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1);
		}
		System.out.println("Enter the course name you want to get info about");
		String name=sc.next();
		try {
			Course crse=course.getCourseInfo(name);
			System.out.println(crse);
		} catch (RecordNotfoundException | SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createBatch() {
		
		System.out.println("Availale course details");
		try {
			ccid.getCourseIdCnameBid();;
		} catch (RecordNotfoundException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1);
		}
		
		System.out.println("Enter the course id under which you want to create the batch");
		int id=sc.nextInt();
		Batch batch = new BatchImpl();
		System.out.println("Enter the batch id you want to create the batch");
		batch.setBatchId(sc.nextInt());
		batch.setCourseId(id);
		
		try {
			course.createBatch(batch);
		} catch (RecordNotfoundException | SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
