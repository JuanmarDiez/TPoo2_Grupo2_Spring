package com.example.TP_OO2_Turnos.models;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.example.TP_OO2_Turnos.entities.Disponibilidad;

public class DiaModel {

    private int id;
    private LocalDate fecha;
    private Set<Disponibilidad> disponibilidades;

    public DiaModel() {}

    public DiaModel(int id, LocalDate fecha, Set<Disponibilidad> disponibilidades) {
        this.id = id;
        this.fecha = fecha;
        this.disponibilidades=disponibilidades;
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

	public Set<Disponibilidad> getDisponibilidades() {
		return disponibilidades;
	}

	public void setDisponibilidades(Set<Disponibilidad> disponibilidades) {
		this.disponibilidades = disponibilidades;
	}
    
}