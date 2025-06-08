package com.example.TP_OO2_Turnos.exception;

public class UnauthorizedException extends RuntimeException{
	
	private final String errorMessage;
	
	public UnauthorizedException(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	
	

}
