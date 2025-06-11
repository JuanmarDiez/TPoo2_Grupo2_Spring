package com.example.TP_OO2_Turnos.models;

import java.util.List;

import com.example.TP_OO2_Turnos.entities.Turno;
import com.example.TP_OO2_Turnos.entities.User;

public class ClienteModel extends UsuarioModel {
	private int nroCliente;
	private List<Turno> turnos;

	public ClienteModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClienteModel(int id,String nombre, String apellido, int dni,int nroCliente, User user) {
		super(id, nombre, apellido, dni, user);
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
