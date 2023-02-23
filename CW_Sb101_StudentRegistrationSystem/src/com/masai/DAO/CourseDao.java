package com.masai.DAO;

import java.util.List;

import com.masai.DTO.Batch;
import com.masai.DTO.Course;
import com.masai.EXCEPTIONS.RecordNotfoundException;
import com.masai.EXCEPTIONS.SomethingWentWrongException;

public interface CourseDao {

	public void addNewCourse(Course course) throws SomethingWentWrongException;
	public void upDateCourseFee(int courseId,int feeAmount) throws RecordNotfoundException,SomethingWentWrongException;
	public void deleteCourse(int courseId) throws RecordNotfoundException,SomethingWentWrongException;
	public Course getCourseInfo(String name) throws RecordNotfoundException,SomethingWentWrongException;
	public void createBatch(Batch batch) throws RecordNotfoundException,SomethingWentWrongException;
	public List<Course> getAllCourseWithSeats() throws RecordNotfoundException,SomethingWentWrongException;
	
	
	
	
}