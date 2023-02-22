package com.masai.EXCEPTIONS;

public class RecordNotfoundException extends Exception{

	public RecordNotfoundException(String message) {
		super(message);
	}
	
	public String toString() {
		return getMessage();
	}

	
}
