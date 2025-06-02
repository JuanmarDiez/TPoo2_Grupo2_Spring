package com.example.TP_OO2_Turnos.services;

import java.util.List;

import com.example.TP_OO2_Turnos.entities.Turno;
import com.example.TP_OO2_Turnos.models.TurnoModel;

public interface ITurnoService {
	public List<Turno> getAll();
	
	public TurnoModel insertOrUpdate(TurnoModel turnoModel);
	
	public boolean remove(int id);
}
