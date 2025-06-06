package com.example.TP_OO2_Turnos.services;

import java.time.LocalDate;
import java.util.List;

import com.example.TP_OO2_Turnos.entities.Turno;
import com.example.TP_OO2_Turnos.models.TurnoModel;

public interface ITurnoService {
	public List<Turno> getAll();
	
	public TurnoModel insertOrUpdate(TurnoModel turnoModel);
	
	public boolean remove(int id);
	
	public List<Turno> buscarPorLugarId(int lugarId);
    
	public List<Turno> buscarPorServicioId(int servicioId);
	
	public List<Turno> buscarPorServicioIdAndLugarId(int servicioId, int lugarId);
	
	public List<Turno> filtrarTurnos(Integer servicioId, Integer lugarId, LocalDate fechaInicio, LocalDate fechaFin);
}
