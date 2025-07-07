package com.example.TP_OO2_Turnos.converters;

import org.springframework.stereotype.Component;

import com.example.TP_OO2_Turnos.dtos.EmpleadoDTO;
import com.example.TP_OO2_Turnos.entities.Empleado;
import com.example.TP_OO2_Turnos.models.EmpleadoModel;

@Component("empleadoConverter")
public class EmpleadoConverter {
	public EmpleadoModel entityToModel(Empleado empleado) {
		return new EmpleadoModel(empleado.getId(),empleado.getNombre(),empleado.getApellido(),empleado.getDni(),empleado.getLegajo(),empleado.getFechaDeAlta(),empleado.isEsActivo(), empleado.getUser());
	}
	
	public Empleado modelToEntity(EmpleadoModel empleadoModel) {
		return new Empleado(empleadoModel.getId(), empleadoModel.getNombre(),empleadoModel.getApellido(),empleadoModel.getDni(),empleadoModel.getLegajo(),empleadoModel.getFechaDeAlta(),empleadoModel.isEsActivo(), empleadoModel.getUser());
	}
	
	public EmpleadoDTO entityToDTO(Empleado empleado) {
		return new EmpleadoDTO(empleado.getId(),empleado.getNombre(),empleado.getApellido(),empleado.getUser().getEmail(),empleado.getUser().getClave(),empleado.getDni(),empleado.getLegajo(),empleado.getFechaDeAlta(),empleado.isEsActivo());
	}
}
