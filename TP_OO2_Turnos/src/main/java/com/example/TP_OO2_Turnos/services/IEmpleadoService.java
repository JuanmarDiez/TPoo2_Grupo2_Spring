package com.example.TP_OO2_Turnos.services;

import java.util.List;


import com.example.TP_OO2_Turnos.entities.Empleado;

import com.example.TP_OO2_Turnos.models.EmpleadoModel;

public interface IEmpleadoService {
	public List<Empleado> getAll();
	
	public boolean remove(int legajo);
	
	public EmpleadoModel insertOrUpdate(EmpleadoModel EmpleadoModel);
	
	public Empleado findByLegajo(int legajo) throws Exception;
}
