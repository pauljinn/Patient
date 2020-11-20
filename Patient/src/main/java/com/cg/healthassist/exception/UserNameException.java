package com.cg.healthassist.exception;

public class UserNameException extends Exception {
	String errorMessage;

	public UserNameException(String errorMessage) {
		super(errorMessage);
	}
	
	public UserNameException() {
		super();
	}
	
	

}
