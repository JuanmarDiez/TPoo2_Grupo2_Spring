package com.example.TP_OO2_Turnos.converters;

import org.springframework.stereotype.Component;

import com.example.TP_OO2_Turnos.entities.Cliente;
import com.example.TP_OO2_Turnos.entities.Empleado;
import com.example.TP_OO2_Turnos.entities.Usuario;
import com.example.TP_OO2_Turnos.models.ClienteModel;
import com.example.TP_OO2_Turnos.models.EmpleadoModel;
import com.example.TP_OO2_Turnos.models.UsuarioModel;

@Component("usuarioConverter")
public class UsuarioConverter {
	
	public UsuarioModel entityToModel(Usuario usuario) {
		return new UsuarioModel(usuario.getId(),usuario.getEmail(),usuario.getClave(),usuario.getNombre(),usuario.getApellido(),usuario.getDni());
	}
	
	public Usuario modelToEntity(UsuarioModel usuarioModel) {
		return new Usuario(usuarioModel.getId(),usuarioModel.getEmail(),usuarioModel.getClave(),usuarioModel.getNombre(),usuarioModel.getApellido(),usuarioModel.getDni());
	}
	
	public EmpleadoModel entityToModel(Empleado empleado) {
		return new EmpleadoModel(empleado.getId(),empleado.getEmail(),empleado.getClave(),empleado.getNombre(),empleado.getApellido(),empleado.getDni(),empleado.getLegajo(),empleado.getFechaDeAlta(),empleado.isEsActivo());
	}
	
	public Empleado modelToEntity(EmpleadoModel empleadoModel) {
		return new Empleado(empleadoModel.getId(),empleadoModel.getEmail(),empleadoModel.getClave(),empleadoModel.getNombre(),empleadoModel.getApellido(),empleadoModel.getDni(),empleadoModel.getLegajo(),empleadoModel.getFechaDeAlta(),empleadoModel.isEsActivo());
	}
	
	public ClienteModel entityToModel(Cliente cliente) {
		return new ClienteModel(cliente.getId(),cliente.getEmail(),cliente.getClave(),cliente.getNombre(),cliente.getApellido(),cliente.getDni(),cliente.getNroCliente());
	}
	
	public Cliente modelToEntity(ClienteModel clienteModel) {
		return new Cliente(clienteModel.getId(),clienteModel.getEmail(),clienteModel.getClave(),clienteModel.getNombre(),clienteModel.getApellido(),clienteModel.getDni(),clienteModel.getNroCliente());
	}
}
