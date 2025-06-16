package com.example.TP_OO2_Turnos.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.TP_OO2_Turnos.exception.TurnoIgualException;
import com.example.TP_OO2_Turnos.exception.UnauthorizedException;

@ControllerAdvice
public class ExceptionController {
	
	
	@ExceptionHandler(value = {UnauthorizedException.class})
	public ResponseEntity<Object> handlerUnauthorizedException(UnauthorizedException e){
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
				.body(e.getErrorMessage());
	}
	
	
	@ExceptionHandler(value = {TurnoIgualException.class})
	public ResponseEntity<Object> handlerTurnoIgualException(TurnoIgualException e){
		return ResponseEntity.status(HttpStatus.CONFLICT)
				.body(e.getErrorMessage());
	}
	
	/*@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> handlerException(Exception e){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("Error en la ejecucion del servicio");
	}*/
	
}
