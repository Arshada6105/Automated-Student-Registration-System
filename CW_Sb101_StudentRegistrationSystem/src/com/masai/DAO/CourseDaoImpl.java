package com.masai.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.DTO.Batch;
import com.masai.DTO.Course;
import com.masai.DTO.CourseImpl;
import com.masai.EXCEPTIONS.RecordNotfoundException;
import com.masai.EXCEPTIONS.SomethingWentWrongException;


public class CourseDaoImpl implements CourseDao{
	

	@Override
	public void addNewCourse(Course course) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtility.connectToDatabase();
			String query ="insert into courses values(?,?,?)";
			PreparedStatement prep = conn.prepareStatement(query);
			prep.setInt(1, course.getCourseId());
			prep.setString(2, course.getCourseName());
			prep.setInt(3, course.getCourseFee());
			
			if(prep.executeUpdate()>0) {
				System.out.println("course added successfully");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		}
		
		try {
			DBUtility.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void upDateCourseFee(int courseId, int feeAmount)
			throws RecordNotfoundException, SomethingWentWrongException {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		try {
			conn=DBUtility.connectToDatabase();
			String upQuery = "update courses set cfee=cfee+? where cid=?";
			PreparedStatement prep = conn.prepareStatement(upQuery);
			prep.setInt(1, feeAmount);
			prep.setInt(2, courseId);
			if(prep.executeUpdate()>0) {
				System.out.println("course fee updated successfully");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		}
		
		try {
			DBUtility.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCourse(int courseId) throws RecordNotfoundException, SomethingWentWrongException {
		// TODO Auto-generated method stub
		Connection conn;
		try {
			conn=DBUtility.connectToDatabase();
			String query = "delete from courses where cid=?";
			PreparedStatement prep = conn.prepareStatement(query);
			prep.setInt(1, courseId);
			if(prep.executeUpdate()>0) {
				System.out.println("course deleted successfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Course getCourseInfo(String name) throws RecordNotfoundException, SomethingWentWrongException {
		// TODO Auto-generated method stub
		Connection conn=null;
		Course course=null;
		try {
			conn=DBUtility.connectToDatabase();
			String query = "Select * from courses where cname=?";
			PreparedStatement prep = conn.prepareStatement(query);
			prep.setString(1, name);
			ResultSet set = prep.executeQuery();
			if(DBUtility.isResultSetEmpty(set)) {
				System.out.println("No such course exists");
			}
			set.next();
			
			course = new CourseImpl(set.getInt("cid"), set.getString("cname"), set.getInt("cfee"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return course;
	}
	
	
	@Override
	public void createBatch(Batch batch) throws RecordNotfoundException, SomethingWentWrongException {
		// TODO Auto-generated method stub
		Connection conn;
		try {
			conn=DBUtility.connectToDatabase();
			String query="insert into batches (bid,cid) values (?,?)";
			PreparedStatement prep = conn.prepareStatement(query);
			prep.setInt(1, batch.getBatchId());
			prep.setInt(2, batch.getCourseId());
			
			if(prep.executeUpdate()>0) {
				System.out.println("Batch created under a course successfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Course> getAllCourseWithSeats() throws RecordNotfoundException, SomethingWentWrongException {
		// TODO Auto-generated method stub
		return null;
	}

}
