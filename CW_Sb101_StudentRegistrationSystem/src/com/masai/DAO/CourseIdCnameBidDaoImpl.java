package com.masai.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.DTO.CourseIdCnameBid;
import com.masai.DTO.CourseIdCnameBidImpl;
import com.masai.EXCEPTIONS.RecordNotfoundException;

public class CourseIdCnameBidDaoImpl implements CourseIdCnameBidDao {

	@Override
	public void getCourseIdCnameBid() throws RecordNotfoundException {
		// TODO Auto-generated method stub
		
		Connection conn;
		List<CourseIdCnameBid> list = new ArrayList<>();
		
		try {
			conn= DBUtility.connectToDatabase();
			
			String query = "Select  c.cid , c.cname Course , b.bid  from courses c left join batches b on c.cid=b.cid";
			
			PreparedStatement prep = conn.prepareStatement(query);
			ResultSet set = prep.executeQuery();
			if(DBUtility.isResultSetEmpty(set)) {
				throw new RecordNotfoundException("No record found");
			}
			
			while(set.next()) {
				list.add(new CourseIdCnameBidImpl(set.getInt("cid"), set.getString("Course"), set.getInt("bid")));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for(CourseIdCnameBid c:list) {
			System.out.println(c);
		}
	}

}
