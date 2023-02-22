package com.masai.DTO;

import java.util.Objects;
import java.util.Set;

public class BatchImpl implements Batch{
	private int batchId;
	private int seats;
	private int courseId;
	private Set<Student> student; //Set of child table (Student)
	private Course course; //object of parent table (Course)
	
	
	
	public BatchImpl() {
	}



	public BatchImpl(int courseId) {
		super();
		this.courseId = courseId;
	}



	public int getBatchId() {
		return batchId;
	}



	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}



	public int getSeats() {
		return seats;
	}



	public void setSeats(int seats) {
		this.seats = seats;
	}



	public int getCourseId() {
		return courseId;
	}



	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}



	public Set<Student> getStudent() {
		return student;
	}



	public void setStudent(Set<Student> student) {
		this.student = student;
	}
	
	



	public Course getCourse() {
		return course;
	}



	public void setCourse(Course course) {
		this.course = course;
	}



	@Override
	public String toString() {
		return "BatchImpl [batchId=" + batchId + ", seats=" + seats + ", courseId=" + courseId + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(batchId);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BatchImpl other = (BatchImpl) obj;
		return batchId == other.batchId ;
	}
	
	
	
	
	
}