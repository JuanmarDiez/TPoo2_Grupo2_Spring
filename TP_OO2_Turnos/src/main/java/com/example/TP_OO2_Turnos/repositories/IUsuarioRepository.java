package com.example.TP_OO2_Turnos.repositories;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TP_OO2_Turnos.entities.Usuario;

@Repository("usuarioRepository")
public interface IUsuarioRepository extends JpaRepository<Usuario, Serializable>{
	
	public abstract Usuario findById(int id);
	Optional<Usuario> findByDni(int dni);

}
