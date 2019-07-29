package com.madinatic.exception;

public class ServiceException extends MadinaticException {

	private boolean duplicated;
	private boolean notExists;
	private String message;
	
	public ServiceException(boolean duplicated,boolean notExists) {
		this.duplicated = duplicated;
		this.notExists = notExists;
		if(duplicated) setMessage("");
	}
	
	public boolean isDuplicated() {
		return duplicated;
	}
	public void setDuplicated(boolean duplicated) {
		this.duplicated = duplicated;
	}
	public boolean isNotExists() {
		return notExists;
	}
	public void setNotExists(boolean notExists) {
		this.notExists = notExists;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	 
}
