package com.masai.UI;

import java.util.List;
import java.util.Scanner;

import com.masai.DAO.CourseDao;
import com.masai.DAO.CourseDaoImpl;
import com.masai.DTO.Batch;
import com.masai.DTO.BatchImpl;
import com.masai.DTO.Course;
import com.masai.DTO.CourseImpl;
import com.masai.EXCEPTIONS.RecordNotfoundException;
import com.masai.EXCEPTIONS.SomethingWentWrongException;

public class CourseUi {
	private CourseDao course;
	private Scanner sc;
	public CourseUi(Scanner sc) {
		course = new CourseDaoImpl();
		this.sc = sc;
	}
	
	public void addCourse() {
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
		System.out.println("All the course details are as follows");
		try {
			
			List<Course> list=course.getAllCourse();
			for(Course c: list) {
				System.out.println(c);
			}
		} catch (RecordNotfoundException | SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createBatch() {
		System.out.println("insert the course id under which you want to create batch");
		Batch batch = new BatchImpl(sc.nextInt());
		try {
			course.createBatch(batch);
		} catch (RecordNotfoundException | SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}