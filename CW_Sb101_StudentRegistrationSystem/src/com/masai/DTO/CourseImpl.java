package com.masai.DTO;

import java.util.Objects;
import java.util.Set;

public class CourseImpl implements Course{

	private int courseId;
	private String courseName;
	private int courseFee;
	private Set<Batch> batch;
	
	
	public CourseImpl() {
		super();
	}


	public CourseImpl(int courseId, String courseName,int coursefee) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseFee=coursefee;
	}


	public int getCourseId() {
		return courseId;
	}


	public int getCourseFee() {
		return courseFee;
	}


	public void setCourseFee(int courseFee) {
		this.courseFee = courseFee;
	}


	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public Set<Batch> getBatch() {
		return batch;
	}


	public void setBatch(Set<Batch> batch) {
		this.batch = batch;
	}





	@Override
	public String toString() {
		return "courseId=" + courseId + ", courseName=" + courseName + ", courseFee=" + courseFee;
	}


	@Override
	public int hashCode() {
		return Objects.hash(courseId);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourseImpl other = (CourseImpl) obj;
		return courseId == other.courseId;
	}
	
	
	
}
