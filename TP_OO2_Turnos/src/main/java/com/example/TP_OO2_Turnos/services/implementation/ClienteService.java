package com.example.TP_OO2_Turnos.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.TP_OO2_Turnos.converters.ClienteConverter;

import com.example.TP_OO2_Turnos.entities.Cliente;

import com.example.TP_OO2_Turnos.models.ClienteModel;
import com.example.TP_OO2_Turnos.repositories.IClienteRepository;

import com.example.TP_OO2_Turnos.services.IClienteService;

@Service("clienteService")
public class ClienteService implements IClienteService {
	@Autowired
	@Qualifier("clienteRepository")
	private IClienteRepository clienteRepository;
	
	@Autowired
	@Qualifier("clienteConverter")
	private ClienteConverter clienteConverter;
	
	@Override
	public List<Cliente> getAll(){
		return clienteRepository.findAll();
	}
	
	@Override
	public ClienteModel insertOrUpdate(ClienteModel clienteModel) {
		Cliente cliente = clienteRepository.save(clienteConverter.modelToEntity(clienteModel));
		return clienteConverter.entityToModel(cliente);
	}
	
	@Override
	public boolean remove(int id) {
		try {
			clienteRepository.deleteById(id);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	@Override
	public Cliente findByNroCliente(int nroCliente) throws Exception{
		return clienteRepository.findByNroCliente(nroCliente);
	}
	
}
