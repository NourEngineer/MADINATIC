package com.madinatic.exception;

public class ServiceException extends MadinaticException {

	private boolean duplicated;
	private String message;
	
	public ServiceException(boolean duplicated) {
		this.duplicated = duplicated;
		if(duplicated) setMessage("Is duplicated");
		else setMessage("");
	}
	
	public boolean isDuplicated() {
		return duplicated;
	}
	public void setDuplicated(boolean duplicated) {
		this.duplicated = duplicated;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	 
}
