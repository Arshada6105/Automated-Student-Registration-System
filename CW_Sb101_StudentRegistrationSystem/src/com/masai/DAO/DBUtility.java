package com.masai.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class DBUtility {
	static final String url;
	static final String username;
	static final String password;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResourceBundle rb = ResourceBundle.getBundle("DBdetails");
		url=rb.getString("url");
		username=rb.getString("username");
		password=rb.getString("password");	
	}
	
	static Connection connectToDatabase() throws SQLException {
		return DriverManager.getConnection(url,username,password);
	}
	
	static void closeConnection(Connection conn) throws SQLException {
		if(conn!=null) {
			conn.close();
		}
	}
	
	static boolean isResultSetEmpty(ResultSet set) throws SQLException {
		return (!set.isBeforeFirst() && set.getRow()==0)?true:false;
	}
	
}
