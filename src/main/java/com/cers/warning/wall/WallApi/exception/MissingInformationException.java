package com.cers.warning.wall.WallApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MissingInformationException extends BusinessException{
	
	private static final long serialVersionUID = -2601408388284183166L;

	public MissingInformationException(String message) {
		super(message);
	}
	
	public MissingInformationException(String message, Throwable e) {
		super(message, e);
	}

}
