package com.cers.warning.wall.WallApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends BusinessException{
	
	private static final long serialVersionUID = -8158230516488888793L;

	public EntityNotFoundException(String message) {
		super(message);
	}
	
	public EntityNotFoundException(String message, Throwable e) {
		super(message, e);
	}

}
