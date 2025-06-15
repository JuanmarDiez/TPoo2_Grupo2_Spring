package com.example.TP_OO2_Turnos.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.TP_OO2_Turnos.converters.UsuarioConverter;

import com.example.TP_OO2_Turnos.entities.Usuario;
import com.example.TP_OO2_Turnos.repositories.IUsuarioRepository;
import com.example.TP_OO2_Turnos.services.IUsuarioService;

@Service("usuarioService")
public class UsuarioService implements IUsuarioService {
	
	@Autowired
	@Qualifier("usuarioRepository")
	private IUsuarioRepository usuarioRepository;
	
	@Autowired
	@Qualifier("usuarioConverter")
	private UsuarioConverter usuarioConverter;
	
	@Override
	public List<Usuario> getAll(){
		return usuarioRepository.findAll();
	}
	
	
	@Override
	public boolean remove(int id) {
		try {
			usuarioRepository.deleteById(id);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@Override
	public Usuario findById(int id) throws Exception{
		return usuarioRepository.findById(id);
	}
	
	
}
