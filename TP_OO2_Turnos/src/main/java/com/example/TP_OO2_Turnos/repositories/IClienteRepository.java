package com.example.TP_OO2_Turnos.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.TP_OO2_Turnos.entities.Cliente;

import jakarta.transaction.Transactional;

@Repository("clienteRepository")
public interface IClienteRepository extends JpaRepository<Cliente, Serializable> {
	public abstract Cliente findByNroCliente(int nroCliente);
	
	@Query("SELECT COALESCE(MAX(c.nroCliente), 1) FROM Cliente c")
    public abstract int obtenerSiguienteCodigo();
}
