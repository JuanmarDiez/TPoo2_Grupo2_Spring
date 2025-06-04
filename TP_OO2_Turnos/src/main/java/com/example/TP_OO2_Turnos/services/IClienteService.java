package com.example.TP_OO2_Turnos.services;

import java.util.List;

import com.example.TP_OO2_Turnos.entities.Cliente;
import com.example.TP_OO2_Turnos.models.ClienteModel;


public interface IClienteService {
	public List<Cliente> getAll();
	
	public boolean remove(int nroCliente);
	
	public ClienteModel insertOrUpdate(ClienteModel clienteModel);
	
	public Cliente findByNroCliente(int nroCliente) throws Exception;
}
