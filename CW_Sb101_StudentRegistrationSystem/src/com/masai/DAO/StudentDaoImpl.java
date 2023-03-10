package com.masai.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.DTO.Student;
import com.masai.DTO.StudentImpl;
import com.masai.EXCEPTIONS.RecordNotfoundException;
import com.masai.EXCEPTIONS.SomethingWentWrongException;

public class StudentDaoImpl implements StudentDao{

	@Override
	public void addStudent(Student student) throws RecordNotfoundException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtility.connectToDatabase();
			String query="insert into students (sname,state,email,phone,password,bid) values(?,?,?,?,?,?)";
			PreparedStatement prep=conn.prepareStatement(query);
			prep.setString(1, student.getName());
			prep.setString(2, student.getState());
			prep.setString(3, student.getEmail());
			prep.setString(4, student.getPhone());
			prep.setString(5, student.getPassword());
			prep.setInt(6,student.getBatchId());
			
			if(prep.executeUpdate()>0) {
				System.out.println("Student added successfully");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RecordNotfoundException("Phone Number Already exist");
		}
		
		try {
			DBUtility.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateStudent(Student student,int sid) throws RecordNotfoundException, SomethingWentWrongException {
		// TODO Auto-generated method stub
		Connection conn= null;
		try {
			conn=DBUtility.connectToDatabase();
			String query="update students set sname=? , state=? ,email=?,phone=?,password=?,bid=? where sid=?";
			PreparedStatement prep=conn.prepareStatement(query);
			prep.setString(1, student.getName());
			prep.setString(2, student.getState());
			prep.setString(3, student.getEmail());
			prep.setString(4, student.getPhone());
			prep.setString(5, student.getPassword());
			prep.setInt(6, student.getBatchId());
			prep.setInt(7, sid);
			
			if(prep.executeUpdate()>0) {
				System.out.println("Student details updated successfully");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			DBUtility.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<Student> getStudentsFromSet(ResultSet set) throws SQLException{
		List<Student> list = new ArrayList<>();
		while(set.next()) {
			Student stu = new StudentImpl();
			stu.setId(set.getInt("sid"));
			stu.setName(set.getString("sname"));
			stu.setState(set.getString("state"));
			stu.setEmail(set.getString("email"));
			stu.setPhone(set.getString("phone"));
			stu.setPassword(set.getString("password"));
			stu.setBatchId(set.getInt("bid"));
			list.add(stu);
		}
		
		return list;
	}

	@Override
	public List<Student> getAllStudent() throws RecordNotfoundException, SomethingWentWrongException {
		// TODO Auto-generated method stub
		Connection conn=null;
		List<Student> list=null;
		try {
			conn=DBUtility.connectToDatabase();
			String query="Select * from students";
			PreparedStatement prep = conn.prepareStatement(query);
			 ResultSet set = prep.executeQuery();
			 if(DBUtility.isResultSetEmpty(set)) {
				 System.out.println("No record found");
			 }
			 
			 list=getStudentsFromSet(set);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public String logIn(String username, String password) throws RecordNotfoundException,SomethingWentWrongException {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		String ans="";
		
		try {
			conn=DBUtility.connectToDatabase();
			String query="Select * from students where email=? and password=?";
			PreparedStatement prep = conn.prepareStatement(query);
			prep.setString(1, username);
			prep.setString(2, password);
			
			ResultSet set = prep.executeQuery();
			
			if(DBUtility.isResultSetEmpty(set)) {
				System.out.println("invalid user name and password");
			}
			
			set.next();
			ans=set.getString("sname")+" Student_Id "+set.getInt("sid");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(new RecordNotfoundException("Please enter valid user and pas"));
		}
		
		return ans;
	}

}
