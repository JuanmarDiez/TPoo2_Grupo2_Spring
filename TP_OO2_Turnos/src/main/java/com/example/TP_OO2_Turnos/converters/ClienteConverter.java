package com.example.TP_OO2_Turnos.converters;

import org.springframework.stereotype.Component;

import com.example.TP_OO2_Turnos.dtos.ClienteDTO;
import com.example.TP_OO2_Turnos.entities.Cliente;
import com.example.TP_OO2_Turnos.models.ClienteModel;

@Component("clienteConverter")
public class ClienteConverter {
	public ClienteModel entityToModel(Cliente cliente) {
		return new ClienteModel(cliente.getId(),cliente.getNombre(),cliente.getApellido(),cliente.getDni(),cliente.getNroCliente(), cliente.getUser());
	}
	
	public Cliente modelToEntity(ClienteModel clienteModel) {
		return new Cliente(clienteModel.getId(),clienteModel.getNombre(),clienteModel.getApellido(),clienteModel.getDni(),clienteModel.getNroCliente(),clienteModel.getUser());
	}
	
	public ClienteDTO entityToDTO(Cliente cliente) {
		return new ClienteDTO(cliente.getId(),cliente.getNombre(),cliente.getApellido(),cliente.getUser().getEmail(),cliente.getUser().getClave(),cliente.getDni(),cliente.getNroCliente());
	}
}
