package com.example.TP_OO2_Turnos.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.example.TP_OO2_Turnos.converters.EmpleadoConverter;

import com.example.TP_OO2_Turnos.entities.Empleado;

import com.example.TP_OO2_Turnos.models.EmpleadoModel;
import com.example.TP_OO2_Turnos.repositories.IEmpleadoRepository;

import com.example.TP_OO2_Turnos.services.IEmpleadoService;


public class EmpleadoService implements IEmpleadoService {
	
	@Autowired
	@Qualifier("empleadoRepository")
	private IEmpleadoRepository empleadoRepository;
	
	@Autowired
	@Qualifier("empleadoConverter")
	private EmpleadoConverter empleadoConverter;
	
	@Override
	public List<Empleado> getAll(){
		return empleadoRepository.findAll();
	}
	
	@Override
	public EmpleadoModel insertOrUpdate(EmpleadoModel empleadoModel) {
		Empleado empleado = empleadoRepository.save(empleadoConverter.modelToEntity(empleadoModel));
		return empleadoConverter.entityToModel(empleado);
	}
	
	@Override
	public boolean remove(int id) {
		try {
			empleadoRepository.deleteById(id);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@Override
	public Empleado findByLegajo(int legajo) throws Exception{
		return empleadoRepository.findByLegajo(legajo);
	}
	
}
