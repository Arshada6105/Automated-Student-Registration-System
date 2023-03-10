package com.masai.DAO;

import java.util.List;

import com.masai.DTO.Student;
import com.masai.EXCEPTIONS.RecordNotfoundException;
import com.masai.EXCEPTIONS.SomethingWentWrongException;

public interface StudentDao {

	public void addStudent(Student student) throws RecordNotfoundException;
	public void updateStudent(Student student,int studentId) throws RecordNotfoundException,SomethingWentWrongException;
	public List<Student> getAllStudent() throws RecordNotfoundException,SomethingWentWrongException;
	public String logIn(String username,String password) throws RecordNotfoundException,SomethingWentWrongException;
	
}
