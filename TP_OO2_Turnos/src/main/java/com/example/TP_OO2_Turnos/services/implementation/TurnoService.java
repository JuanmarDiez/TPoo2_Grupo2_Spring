package com.example.TP_OO2_Turnos.services.implementation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.TP_OO2_Turnos.converters.TurnoConvert;
import com.example.TP_OO2_Turnos.entities.Turno;
import com.example.TP_OO2_Turnos.exception.TurnoNotFoundException;
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
	
	@Override
	public List<Turno> buscarPorLugarId(int lugarId){
		List<Turno> turno = turnoRepository.findByLugarId(lugarId);
		if(turno.isEmpty()) throw new TurnoNotFoundException("No existe ningun turno con esos detalles");
		return turno;
	}
    
	@Override
	public List<Turno> buscarPorServicioId(int servicioId){
		List<Turno> turno = turnoRepository.findByServicioId(servicioId);
		if(turno.isEmpty()) throw new TurnoNotFoundException("No existe ningun turno con esos detalles");
		return turno;
	}

	@Override
	public List<Turno> buscarPorServicioIdAndLugarId(int servicioId, int lugarId) {
		List<Turno> turno = turnoRepository.findByServicioIdAndLugarId(servicioId, lugarId);
		if(turno.isEmpty()) throw new TurnoNotFoundException("No existe ningun turno con esos detalles");
		return turno;
	}
	
	public List<Turno> filtrarTurnos(Integer servicioId, Integer lugarId, LocalDate fechaInicio, LocalDate fechaFin) {
	    
		List<Turno> turno =  turnoRepository.buscarFiltrado(servicioId, lugarId, fechaInicio, fechaFin);
		if(turno.isEmpty()) throw new TurnoNotFoundException("No existe ningun turno con esos detalles");
		return turno;
	}
	
	public Turno buscarTurnoBD(int nroCliente,int legajo, LocalTime hora, LocalDate fecha, int servicioId, int lugarId) {
		return turnoRepository.findTurnoPorFiltros(nroCliente, legajo, hora, fecha, servicioId, lugarId);
	};
}
