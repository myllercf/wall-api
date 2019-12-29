package com.cers.warning.wall.WallApi.exception;

public class BusinessException extends RuntimeException{
	
	private static final long serialVersionUID = 339041228309516812L;

	public BusinessException(String message) {
		super(message);
	}
	
	public BusinessException(String message, Throwable e) {
		super(message, e);
	}

}
