package com.example.TP_OO2_Turnos.exception;

public class TurnoIgualException extends RuntimeException {
	private final String errorMessage;

	public TurnoIgualException(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
