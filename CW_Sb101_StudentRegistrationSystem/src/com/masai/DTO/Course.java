package com.masai.DTO;

import java.util.Set;

public interface Course {

	public int getCourseId() ;


	public void setCourseId(int courseId) ;


	public String getCourseName() ;
	public void setCourseName(String courseName);


	public Set<Batch> getBatch();


	public void setBatch(Set<Batch> batch) ;
	
	public int getCourseFee();


	public void setCourseFee(int courseFee) ;

}
