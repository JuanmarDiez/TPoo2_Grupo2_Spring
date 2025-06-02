package com.example.TP_OO2_Turnos.services;

import java.util.List;

import com.example.TP_OO2_Turnos.entities.Cliente;
import com.example.TP_OO2_Turnos.entities.Empleado;
import com.example.TP_OO2_Turnos.entities.Usuario;
import com.example.TP_OO2_Turnos.models.UsuarioModel;

public interface IUsuarioService {
	
	public List<Usuario> getAll();
	
	public UsuarioModel insertOrUpdate(UsuarioModel usuarioModel);
	
	public boolean remove(int id);
	
	public Usuario findById(int id) throws Exception;
	
	public Cliente findByNroCliente(int nroCliente) throws Exception;
	
	public Empleado findByLegajo(int legajo) throws Exception;
}
