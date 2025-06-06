package com.example.TP_OO2_Turnos.models;

import java.time.LocalTime;

import com.example.TP_OO2_Turnos.entities.Cliente;
import com.example.TP_OO2_Turnos.entities.Dia;
import com.example.TP_OO2_Turnos.entities.Empleado;

public class TurnoModel {
	private int id;
	private Cliente cliente;
	private Empleado empleado;
	private int dia;
	private LocalTime hora;
	
	public TurnoModel() {}

	public TurnoModel(int id,Cliente cliente, Empleado empleado, int dia, LocalTime hora) {
		super();
		this.id=id;
		this.cliente = cliente;
		this.empleado = empleado;
		this.dia = dia;
		this.hora = hora;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	
	
}
