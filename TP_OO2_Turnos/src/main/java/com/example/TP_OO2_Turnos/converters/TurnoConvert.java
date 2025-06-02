package com.example.TP_OO2_Turnos.converters;

import org.springframework.stereotype.Component;

import com.example.TP_OO2_Turnos.entities.Turno;
import com.example.TP_OO2_Turnos.models.TurnoModel;

@Component("turnoConvert")
public class TurnoConvert {
	
	public TurnoModel entityToModel(Turno turno) {
		return new TurnoModel(turno.getId(),turno.getCliente(),turno.getEmpleado(),turno.getDia(),turno.getHora());
	}
	
	public Turno modelToEntity(TurnoModel turnoModel) {
		return new Turno(turnoModel.getId(),turnoModel.getCliente(),turnoModel.getEmpleado(),turnoModel.getDia(),turnoModel.getHora());
	}
}
