package com.example.TP_OO2_Turnos.exception;

public class TurnoNotFoundException extends RuntimeException {
	private final String errorMessage;

	public TurnoNotFoundException(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	
	
}
