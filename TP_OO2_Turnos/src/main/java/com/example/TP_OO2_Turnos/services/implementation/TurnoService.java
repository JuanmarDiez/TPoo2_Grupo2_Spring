package com.example.TP_OO2_Turnos.services.implementation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.TP_OO2_Turnos.converters.TurnoConvert;
import com.example.TP_OO2_Turnos.entities.Cliente;
import com.example.TP_OO2_Turnos.entities.Dia;
import com.example.TP_OO2_Turnos.entities.Empleado;
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
	
	@Override
	public List<Turno> buscarPorLugarId(int lugarId){
		return turnoRepository.findByLugarId(lugarId);
	}
    
	@Override
	public List<Turno> buscarPorServicioId(int servicioId){
		return turnoRepository.findByServicioId(servicioId);
	}

	@Override
	public List<Turno> buscarPorServicioIdAndLugarId(int servicioId, int lugarId) {
		return turnoRepository.findByServicioIdAndLugarId(servicioId, lugarId);
	}
	
	public List<Turno> filtrarTurnos(Integer servicioId, Integer lugarId, LocalDate fechaInicio, LocalDate fechaFin) {
	    
		return turnoRepository.buscarFiltrado(servicioId, lugarId, fechaInicio, fechaFin);
	}
	
	public Turno buscarTurnoBD(int nroCliente,int legajo, LocalTime hora, LocalDate fecha, int servicioId, int lugarId) {
		return turnoRepository.findTurnoPorFiltros(nroCliente, legajo, hora, fecha, servicioId, lugarId);
	};
	
	/*public void registrarTurnoSiNoExiste(Cliente cliente, Empleado empleado, Dia dia, LocalTime hora) {
        if (!turnoRepository.existsByClienteAndEmpleadoAndDiaAndHora(cliente, empleado, dia, hora)) {
            Turno turno = new Turno();
            turno.setCliente(cliente);
            turno.setEmpleado(empleado);
            turno.setDia(dia);
            turno.setHora(hora);
            turnoRepository.save(turno);
        }
    }*/
	public Turno registrarTurnoSiNoExiste(Cliente cliente, Empleado empleado, Dia dia, LocalTime hora) {
		Turno turno = turnoRepository.findByClienteAndEmpleadoAndDiaAndHora(cliente, empleado, dia, hora);
        if (turno == null) {
            turno = new Turno();
            turno.setCliente(cliente);
            turno.setEmpleado(empleado);
            turno.setDia(dia);
            turno.setHora(hora);
            turnoRepository.save(turno);
        }
        return turno;
    }
}
