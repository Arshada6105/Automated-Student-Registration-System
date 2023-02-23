package com.masai.UI;

import java.util.List;
import java.util.Scanner;

import com.masai.DAO.CourseSeatsDao;
import com.masai.DAO.CourseSeatsDaoImpl;
import com.masai.DTO.CourseSeats;
import com.masai.EXCEPTIONS.SomethingWentWrongException;

public class CourseSeatsUi {
	Scanner sc;
	CourseSeatsDao csDao;
	

	public CourseSeatsUi(Scanner sc) {
		super();
		this.sc = sc;
		csDao = new CourseSeatsDaoImpl();
	}

	public void getAllList() {
		System.out.println("The list of courses and total seats are as follows");
		try {
			List<CourseSeats> list=csDao.getCourseSeats();
			for(CourseSeats cs :list) {
				System.out.println(cs);
			}
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
