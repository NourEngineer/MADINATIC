package com.madinatic.exception;

public class EmployeeException extends MadinaticException{

	/**
	 * 
	 */
	public EmployeeException() {
		message = "Invalid ID_CARD";
	}
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
