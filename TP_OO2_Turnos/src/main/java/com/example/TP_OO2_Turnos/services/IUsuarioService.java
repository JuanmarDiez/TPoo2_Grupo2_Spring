package com.example.TP_OO2_Turnos.services;

import java.util.List;


import com.example.TP_OO2_Turnos.entities.Usuario;


public interface IUsuarioService {
	
	public List<Usuario> getAll();
	
	public boolean remove(int id);
	
	public Usuario findById(int id) throws Exception;
	
}
