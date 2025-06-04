package com.example.TP_OO2_Turnos.converters;

import org.springframework.stereotype.Component;

import com.example.TP_OO2_Turnos.entities.Cliente;
import com.example.TP_OO2_Turnos.models.ClienteModel;

@Component("clienteConverter")
public class ClienteConverter {
	public ClienteModel entityToModel(Cliente cliente) {
		return new ClienteModel(cliente.getId(),cliente.getEmail(),cliente.getClave(),cliente.getNombre(),cliente.getApellido(),cliente.getDni(),cliente.getNroCliente());
	}
	
	public Cliente modelToEntity(ClienteModel clienteModel) {
		return new Cliente(clienteModel.getId(),clienteModel.getEmail(),clienteModel.getClave(),clienteModel.getNombre(),clienteModel.getApellido(),clienteModel.getDni(),clienteModel.getNroCliente());
	}
}
