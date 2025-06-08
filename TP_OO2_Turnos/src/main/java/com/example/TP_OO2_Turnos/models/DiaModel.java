package com.example.TP_OO2_Turnos.models;

import java.time.LocalDate;

import com.example.TP_OO2_Turnos.entities.Disponibilidad;

public class DiaModel {

    private int id;
    private LocalDate fecha;
    
    private Disponibilidad disponibilidad;

    public DiaModel() {}

    public DiaModel(int id, LocalDate fecha, Disponibilidad disponibilidad) {
        this.id = id;
        this.fecha = fecha;
        this.disponibilidad=disponibilidad;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Disponibilidad getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(Disponibilidad disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

    
    
}