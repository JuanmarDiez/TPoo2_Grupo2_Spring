package com.example.TP_OO2_Turnos.converters;

import org.springframework.stereotype.Component;

import com.example.TP_OO2_Turnos.entities.Usuario;
import com.example.TP_OO2_Turnos.models.UsuarioModel;

@Component("usuarioConverter")
public class UsuarioConverter {
	
	public UsuarioModel entityToModel(Usuario usuario) {
		return new UsuarioModel(usuario.getId(),usuario.getEmail(),usuario.getClave(),usuario.getNombre(),usuario.getApellido(),usuario.getDni());
	}
	
	public Usuario modelToEntity(UsuarioModel usuarioModel) {
		return new Usuario(usuarioModel.getId(),usuarioModel.getEmail(),usuarioModel.getClave(),usuarioModel.getNombre(),usuarioModel.getApellido(),usuarioModel.getDni());
	}
}
