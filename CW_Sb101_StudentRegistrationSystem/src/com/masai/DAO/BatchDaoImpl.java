package com.masai.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.masai.EXCEPTIONS.RecordNotfoundException;
import com.masai.EXCEPTIONS.SomethingWentWrongException;

public class BatchDaoImpl implements BatchDao{

	@Override
	public void updateTotalSeats(int batchId,int updatedSize) throws RecordNotfoundException, SomethingWentWrongException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtility.connectToDatabase();
			String query ="update Batches set seats=? where bid=?";
			PreparedStatement prep=conn.prepareStatement(query);
			prep.setInt(1, updatedSize);
			prep.setInt(2, batchId);
			
			if(prep.executeUpdate()>0) {
				System.out.println("batch size updated successfully");
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

	@Override
	public void getStudentsofBatch() throws RecordNotfoundException {
		// TODO Auto-generated method stub
		
	}

}
