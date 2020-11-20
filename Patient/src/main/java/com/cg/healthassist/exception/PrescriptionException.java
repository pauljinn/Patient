package com.cg.healthassist.exception;

public class PrescriptionException extends Exception {
	String msg;

	public PrescriptionException(String msg) {
		super(msg);
	}
	
	public PrescriptionException() {
		super();
	}

}
