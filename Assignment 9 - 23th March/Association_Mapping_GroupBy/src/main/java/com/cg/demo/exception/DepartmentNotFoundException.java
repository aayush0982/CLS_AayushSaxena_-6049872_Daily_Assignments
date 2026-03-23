package com.cg.demo.exception;

@SuppressWarnings("serial")
public class DepartmentNotFoundException extends RuntimeException {
	public DepartmentNotFoundException(String message) {
		super(message);
	}

}
