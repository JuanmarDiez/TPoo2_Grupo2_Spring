package com.example.TP_OO2_Turnos.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.TP_OO2_Turnos.entities.Empleado;

@Repository("empleadoRepository")
public interface IEmpleadoRepository extends JpaRepository<Empleado, Serializable> {
	public abstract Empleado findByLegajo(int legajo);
	
	@Query("SELECT COALESCE(MAX(e.legajo), 1) FROM Empleado e")
    public abstract int obtenerSiguienteCodigo();
}
