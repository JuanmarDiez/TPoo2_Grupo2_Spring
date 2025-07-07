package com.example.TP_OO2_Turnos.models;

import com.example.TP_OO2_Turnos.entities.Dia;
import com.example.TP_OO2_Turnos.entities.Lugar;
import com.example.TP_OO2_Turnos.entities.Servicio;
import com.example.TP_OO2_Turnos.enums.DiaLaborable;

import java.time.LocalTime;
import java.util.List;
import java.util.Set;

public record DisponibilidadModel (
		
		int id,
		Lugar lugar,
		Servicio servicio,
	    LocalTime horaInicio,
	    LocalTime horaFin,
	    Set<DiaLaborable> diasLaborables,
	    List<Dia> dias
		
		){
    
}
