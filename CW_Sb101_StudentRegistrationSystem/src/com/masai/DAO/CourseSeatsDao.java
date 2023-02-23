package com.masai.DAO;

import java.util.List;

import com.masai.DTO.CourseSeats;
import com.masai.EXCEPTIONS.SomethingWentWrongException;

public interface CourseSeatsDao  {

	public List<CourseSeats> getCourseSeats() throws SomethingWentWrongException;
}
