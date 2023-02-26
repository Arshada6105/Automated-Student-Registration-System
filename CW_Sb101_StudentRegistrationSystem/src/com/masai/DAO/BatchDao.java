package com.masai.DAO;


import com.masai.EXCEPTIONS.RecordNotfoundException;
import com.masai.EXCEPTIONS.SomethingWentWrongException;

public interface BatchDao {

	public void updateTotalSeats(int batchId,int updatedSize) throws RecordNotfoundException,SomethingWentWrongException;
	public void getStudentsofBatch() throws RecordNotfoundException;
	public void decreaseSeats(int bid) throws RecordNotfoundException;
	
}
