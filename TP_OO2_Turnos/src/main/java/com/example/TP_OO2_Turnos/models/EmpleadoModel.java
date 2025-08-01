package com.example.TP_OO2_Turnos.models;

import java.time.LocalDate;
import java.util.List;

import com.example.TP_OO2_Turnos.entities.Turno;
import com.example.TP_OO2_Turnos.entities.User;

public class EmpleadoModel extends UsuarioModel {
	private int legajo;
	private LocalDate fechaDeAlta;
	private boolean esActivo;
	private List<Turno> turnos;
	
	public EmpleadoModel() {}
	
	public EmpleadoModel(int id,String nombre, String apellido, int dni, int legajo,LocalDate fechaDeAlta, boolean esActivo, User user) {
		super(id, nombre, apellido, dni, user);
		this.legajo=legajo;
		this.fechaDeAlta=fechaDeAlta;
		this.esActivo=esActivo;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public LocalDate getFechaDeAlta() {
		return fechaDeAlta;
	}

	public void setFechaDeAlta(LocalDate fechaDeAlta) {
		this.fechaDeAlta = fechaDeAlta;
	}

	public boolean isEsActivo() {
		return esActivo;
	}

	public void setEsActivo(boolean esActivo) {
		this.esActivo = esActivo;
	}

	public List<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}

	@Override
	public String toString() {
		return "EmpleadoModel [legajo=" + legajo + ", fechaDeAlta=" + fechaDeAlta + ", esActivo=" + esActivo
				+ ", turnos=" + turnos + "]";
	}
	
	
	
}
