package com.masai.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.DTO.CourseSeats;
import com.masai.DTO.CourseSeatsImpl;
import com.masai.EXCEPTIONS.SomethingWentWrongException;

public class CourseSeatsDaoImpl implements CourseSeatsDao{
	
	
	
	public List<CourseSeats> SetToList(ResultSet set) throws SQLException{
		List<CourseSeats> list = new ArrayList<>();
		while(set.next()) {
			list.add(new CourseSeatsImpl(set.getString("cname"), set.getInt("Total_Seats")));
		}
		
		return list;
	}

	@Override
	public List<CourseSeats> getCourseSeats() throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		Connection conn=null;
		List<CourseSeats> list =null;
		try {
			conn=DBUtility.connectToDatabase();
			String query="select cname , sum(seats) Total_Seats from courses c inner join batches b on c.cid=b.cid group by cname";
			PreparedStatement prep = conn.prepareStatement(query);
			ResultSet set = prep.executeQuery();
			
			if(DBUtility.isResultSetEmpty(set)) {
				System.out.println("no such data of seats and course exists");
			}
			
			list=SetToList(set);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	
}
