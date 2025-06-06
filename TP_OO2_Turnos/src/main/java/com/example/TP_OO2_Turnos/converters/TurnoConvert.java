package com.example.TP_OO2_Turnos.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.TP_OO2_Turnos.entities.Turno;
import com.example.TP_OO2_Turnos.models.TurnoModel;
import com.example.TP_OO2_Turnos.services.IDiaService;

@Component("turnoConvert")
public class TurnoConvert {
	
	@Autowired
	@Qualifier("diaService")
	private IDiaService diaService;
	
	public TurnoModel entityToModel(Turno turno) {
		return new TurnoModel(turno.getId(),turno.getCliente(),turno.getEmpleado(),turno.getDia().getId(),turno.getHora());
	}
	
	public Turno modelToEntity(TurnoModel turnoModel) {
		return new Turno(turnoModel.getId(),turnoModel.getCliente(),turnoModel.getEmpleado(),diaService.findById(turnoModel.getDia()),turnoModel.getHora());
	}
}
