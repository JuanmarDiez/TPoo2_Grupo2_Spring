package com.example.TP_OO2_Turnos.models;

import java.util.List;

import com.example.TP_OO2_Turnos.entities.Turno;

public class ClienteModel extends UsuarioModel {
	private int nroCliente;
	private List<Turno> turnos;

	public ClienteModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClienteModel(int id, String email, String clave, String nombre, String apellido, int dni,int nroCliente) {
		super(id, email, clave, nombre, apellido, dni);
		this.nroCliente = nroCliente;
	}

	public int getNroCliente() {
		return nroCliente;
	}

	public void setNroCliente(int nroCliente) {
		this.nroCliente = nroCliente;
	}

	public List<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}
	
	
	
}
