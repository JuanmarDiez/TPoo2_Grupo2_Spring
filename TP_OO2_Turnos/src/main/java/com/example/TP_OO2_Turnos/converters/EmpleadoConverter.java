package com.example.TP_OO2_Turnos.converters;

import org.springframework.stereotype.Component;

import com.example.TP_OO2_Turnos.entities.Empleado;
import com.example.TP_OO2_Turnos.models.EmpleadoModel;

@Component("empleadoConverter")
public class EmpleadoConverter {
	public EmpleadoModel entityToModel(Empleado empleado) {
		return new EmpleadoModel(empleado.getId(),empleado.getEmail(),empleado.getClave(),empleado.getNombre(),empleado.getApellido(),empleado.getDni(),empleado.getLegajo(),empleado.getFechaDeAlta(),empleado.isEsActivo());
	}
	
	public Empleado modelToEntity(EmpleadoModel empleadoModel) {
		return new Empleado(empleadoModel.getId(),empleadoModel.getEmail(),empleadoModel.getClave(),empleadoModel.getNombre(),empleadoModel.getApellido(),empleadoModel.getDni(),empleadoModel.getLegajo(),empleadoModel.getFechaDeAlta(),empleadoModel.isEsActivo());
	}
}
