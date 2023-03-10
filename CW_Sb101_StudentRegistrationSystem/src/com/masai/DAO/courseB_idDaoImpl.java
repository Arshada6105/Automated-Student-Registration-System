package com.masai.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.DTO.courseB_id;
import com.masai.DTO.courseB_idImpl;
import com.masai.EXCEPTIONS.RecordNotfoundException;

public class courseB_idDaoImpl implements courseB_idDao {

	@Override
	public void showCoursebid() throws RecordNotfoundException {
		// TODO Auto-generated method stub
		Connection conn= null;
		List<courseB_id> list = new ArrayList<>();
		try {
			conn=DBUtility.connectToDatabase();
			String query="Select  b.bid , c.cname Course , b.seats Available_seats  from courses c inner join batches b on c.cid=b.cid";
			PreparedStatement prep = conn.prepareStatement(query);
			ResultSet set = prep.executeQuery();
			
			if(DBUtility.isResultSetEmpty(set)) {
				throw new RecordNotfoundException("No course available");
			}
			
			while(set.next()) {
				list.add(new courseB_idImpl(set.getString("Course"), set.getInt("bid"), set.getInt("Available_seats")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(courseB_id c: list) {
			System.out.println(c);
		}
	}

}
