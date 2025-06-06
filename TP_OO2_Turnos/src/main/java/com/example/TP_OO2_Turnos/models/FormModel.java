package com.example.TP_OO2_Turnos.models;

import java.util.ArrayList;
import java.util.List;

import com.example.TP_OO2_Turnos.entities.Lugar;
import com.example.TP_OO2_Turnos.entities.Servicio;

public class FormModel {
	private Servicio servicio;
	private List<Lugar> lugar;
	
	public FormModel() {}
	
	public FormModel(Servicio servicioId) {
		super();
		this.servicio = servicioId;
		this.lugar = new ArrayList<>();
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public List<Lugar> getLugar() {
		return lugar;
	}

	public void setLugar(List<Lugar> lugar) {
		this.lugar = lugar;
	}	
	
}
