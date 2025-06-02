package com.example.TP_OO2_Turnos.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.TP_OO2_Turnos.converters.TurnoConvert;
import com.example.TP_OO2_Turnos.entities.Turno;
import com.example.TP_OO2_Turnos.models.TurnoModel;
import com.example.TP_OO2_Turnos.repositories.ITurnoRepository;
import com.example.TP_OO2_Turnos.services.ITurnoService;

@Service("turnoService")
public class TurnoService implements ITurnoService {
	@Autowired
	@Qualifier("turnoRepository")
	private ITurnoRepository turnoRepository;
	
	@Autowired
	@Qualifier("turnoConvert")
	private TurnoConvert turnoConvert;
	
	@Override
	public List<Turno> getAll(){
		return turnoRepository.findAll();
	}
	
	@Override
	public TurnoModel insertOrUpdate(TurnoModel turnoModel) {
		Turno turno = turnoRepository.save(turnoConvert.modelToEntity(turnoModel));
		return turnoConvert.entityToModel(turno);
	}
	
	@Override
	public boolean remove(int id) {
		try {
			turnoRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
}
