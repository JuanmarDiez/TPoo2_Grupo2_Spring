package com.example.TP_OO2_Turnos.converters;

import org.springframework.stereotype.Component;

import com.example.TP_OO2_Turnos.entities.Usuario;
import com.example.TP_OO2_Turnos.models.UsuarioModel;

@Component("usuarioConverter")
public class UsuarioConverter {
	
	public UsuarioModel entityToModel(Usuario usuario) {
		return new UsuarioModel(usuario.getId(),usuario.getNombre(),usuario.getApellido(),usuario.getDni(), usuario.getUser());
	}
	
	public Usuario modelToEntity(UsuarioModel usuarioModel) {
		return new Usuario(usuarioModel.getId(),usuarioModel.getNombre(),usuarioModel.getApellido(),usuarioModel.getDni(), usuarioModel.getUser());
	}
	
}
