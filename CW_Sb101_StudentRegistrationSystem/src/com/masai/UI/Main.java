package com.masai.UI;

import java.util.Scanner;

import com.masai.EXCEPTIONS.RecordNotfoundException;

public class Main {
	private static StudentUi studentUi;
	private static CourseUi courseUi;
	private static BatchUi batchUi;
	private static CourseSeatsUi csUi;
	
	
	static void displayAdminMenu() {
		System.out.println("Enter your choice admin.");
		System.out.println("1. Add a new course.");
		System.out.println("2. update fees of a coure.");
		System.out.println("3. Delete a course from any training session.");
		System.out.println("4. Search information about a course.");
		System.out.println("5. Create batch under a course.");
//		System.out.println("6. Allocate students in a batch under a course.");
		System.out.println("7. Update total seats of a batch");
		System.out.println("8. View the students of every batch");
		System.out.println("0. Exit");
	}
	
	
	static void adminMenu(Scanner sc) {
		int choice=0;
		do {
			displayAdminMenu();
			choice=sc.nextInt();
			switch(choice) {
			case 0:
				System.out.println("Thank you visit again admin");
				break;
				
			case 1:
				courseUi.addCourse();
				System.out.println();
				break;
				
			case 2:
				courseUi.updateCourse();
				System.out.println();
				break;
				
			case 3:
				courseUi.deleteCourse();
				System.out.println();
				break;
			
			case 4:
				courseUi.courseinfo();
				System.out.println();
				break;
				
			case 5:
				courseUi.createBatch();
				System.out.println();
				break;
			// DonT forget to create CASE 6 over here	
			case 7:
				batchUi.updateSeats();	
				System.out.println();
				break;
			
			case 8:
				studentUi.getStudentLists();
				System.out.println();
				break;
			}
			
		}while(choice!=0);
	}
	
	static void adminLogin(Scanner sc) {
		System.out.println("Enter username");
		String username=sc.next();
		System.out.println("Enter password");
		String password=sc.next();
		if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
			System.out.println("Login Successfull\nWelcome Admin");
			adminMenu(sc);		
		}else {
			System.out.println("Wrong Credentials Admin");
		}
	}
	static void displayStudentMenu() {
		System.out.println("Enter Your Choice Student");
		System.out.println("1. update Student details.");
		System.out.println("2. Watch All the course list and seat availibility.");
		System.out.println("0. Exit.");
		System.out.println();
		
	}
	
	static void studentMenu(Scanner sc) {
		int choice=0;
		do {
		displayStudentMenu();
		choice=sc.nextInt();
		switch(choice) {
		case 0:
			System.out.println("Thank you! have a nice day student");
			break;
		case 1:
			studentUi.updateStudent();
			System.out.println();
			break;
			
		case 2:
			csUi.getAllList();
			System.out.println();
		}
			
			
		}while(choice!=0);
	}
	
	
	
	static void studentLogin(Scanner sc) {
		System.out.println("Already a user , Enter user name and password");
		if(studentUi.login()==false) {
			System.out.println("Try again");
			return;
		}
			
			studentMenu(sc);
		
	}
	
	static void StudentResgistration(Scanner sc) {
		int bid=0;
		try {
			bid = studentUi.registration();
			if(bid!=0) {
				batchUi.decSeats(bid);
			}
		} catch (RecordNotfoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		
	}
	
	
	
	
 public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	 studentUi = new StudentUi(sc);
	 courseUi = new CourseUi(sc);
	 batchUi = new BatchUi(sc);
	 csUi = new CourseSeatsUi(sc);
	 
	 int choice = 0;
	 
	 do {
		 System.out.println("********Home Page Menu*******");
		 System.out.println("1. Admin Login\n2. Student Login\n3. New User Registration\n0. Exit");
		if(sc.hasNextInt()) {
			choice=sc.nextInt();
		}else {
			System.out.println("Input should be a number");
			break;
		}
		
	 
		 
		switch(choice) {
		case 0:
			System.out.println("Thank You, Visit again");
			break;
		case 1:
			adminLogin(sc);
			break;
		case 2:
			studentLogin(sc);
			break;
		case 3:
			StudentResgistration(sc);
			break;
		default:
			System.out.println("Invalid input!, Please try again ");
		}
	 }while(choice!=0);
	 sc.close();
	 
	 
}
	
}
