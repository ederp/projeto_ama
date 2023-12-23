package com.ama.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class TokenRefreshException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6001892501024250311L;

	public TokenRefreshException(String token, String message) {
	    super(String.format("Falha [%s]: %s", token, message));
	  }
}
