package com.example.TP_OO2_Turnos.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.example.TP_OO2_Turnos.entities.Cliente;
import com.example.TP_OO2_Turnos.entities.Dia;
import com.example.TP_OO2_Turnos.entities.Empleado;
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
	
	public Turno buscarTurnoBD(int nroCliente,int legajo, LocalTime hora, LocalDate fecha, int servicioId, int lugarId);
	
	//public void registrarTurnoSiNoExiste(Cliente cliente, Empleado empleado, Dia dia, LocalTime hora);
	
	public Turno registrarTurnoSiNoExiste(Cliente cliente, Empleado empleado, Dia dia, LocalTime hora);
	
	public Turno findByDiaAndHora(Dia dia, LocalTime hora);
}
