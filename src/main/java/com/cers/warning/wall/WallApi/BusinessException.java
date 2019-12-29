package com.cers.warning.wall.WallApi;

public class BusinessException extends RuntimeException{
	
	private static final long serialVersionUID = 339041228309516812L;

	public BusinessException(String message) {
		super(message);
	}

}
