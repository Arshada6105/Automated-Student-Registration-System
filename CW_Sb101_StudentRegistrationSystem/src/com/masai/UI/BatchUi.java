package com.masai.UI;

import java.util.Scanner;

import com.masai.DAO.BatchDao;
import com.masai.DAO.BatchDaoImpl;

public class BatchUi {
	BatchDao batch;
	Scanner sc;
	public BatchUi(Scanner sc) {
		batch = new BatchDaoImpl();
		this.sc = sc;
	}
	
	
}