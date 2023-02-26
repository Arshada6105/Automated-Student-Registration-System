package com.masai.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.DTO.Course_Id_name;
import com.masai.DTO.Course_Id_nameImpl;
import com.masai.EXCEPTIONS.RecordNotfoundException;

public class Course_Id_nameDaoImpl implements Course_Id_nameDao {

	@Override
	public void showAllCourseIdName() throws RecordNotfoundException {
		// TODO Auto-generated method stub
	List<Course_Id_name> list = new ArrayList<>();
	Connection conn;
	try {
		conn= DBUtility.connectToDatabase();
		String query="select cid , cname from courses";
		PreparedStatement prep = conn.prepareStatement(query);
		ResultSet set = prep.executeQuery();
		if(DBUtility.isResultSetEmpty(set)) {
			throw new RecordNotfoundException("No record found");
		}
		while(set.next()) {
			list.add(new Course_Id_nameImpl(set.getInt("cid"), set.getString("cname")));
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	for(Course_Id_name c:list) {
		System.out.println(c);
	}
		
	}

	
}
