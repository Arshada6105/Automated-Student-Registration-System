package com.masai.UI;

import java.util.Scanner;

import com.masai.DAO.BatchDao;
import com.masai.DAO.BatchDaoImpl;
import com.masai.EXCEPTIONS.RecordNotfoundException;
import com.masai.EXCEPTIONS.SomethingWentWrongException;

public class BatchUi {
	BatchDao batch;
	Scanner sc;
	public BatchUi(Scanner sc) {
		batch = new BatchDaoImpl();
		this.sc = sc;
	}
	
	public void updateSeats() {
		System.out.println("Enter the batch id");
		int id=sc.nextInt();
		System.out.println("Enter the updated total seats");
		int seats=sc.nextInt();
		try {
			batch.updateTotalSeats(id, seats);
		} catch (RecordNotfoundException | SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void decSeats(int bid) {
		
		try {
			batch.decreaseSeats(bid);
		} catch (RecordNotfoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}