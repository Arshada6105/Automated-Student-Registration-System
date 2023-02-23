package com.masai.DTO;

public class CourseSeatsImpl implements CourseSeats{
	private String courseName;
	private int totalSeats;
	
	
	
	public CourseSeatsImpl() {
		super();
	}



	public CourseSeatsImpl(String courseName, int totalSeats) {
		super();
		this.courseName = courseName;
		this.totalSeats = totalSeats;
	}



	public String getCourseName() {
		return courseName;
	}



	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}



	public int getTotalSeats() {
		return totalSeats;
	}



	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}



	@Override
	public String toString() {
		return "CourseSeatsImpl [courseName=" + courseName + ", totalSeats=" + totalSeats + "]";
	}
	
	
	
	
	
}
