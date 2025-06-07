package com.example.TP_OO2_Turnos.repositories;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.example.TP_OO2_Turnos.entities.Turno;

@Repository("turnoRepository")
public interface ITurnoRepository extends JpaRepository<Turno, Serializable> {
	public abstract Turno findById(int id);
	
	@Query("SELECT t FROM Turno t WHERE t.dia.disponibilidad.lugar.id = :lugarId")
	public abstract List<Turno> findByLugarId(int lugarId);
    
	@Query("SELECT t FROM Turno t WHERE t.dia.disponibilidad.servicio.id = :servicioId")
	public abstract List<Turno> findByServicioId(int servicioId);
    
    @Query("SELECT t FROM Turno t WHERE t.dia.disponibilidad.servicio.id = :servicioId AND t.dia.disponibilidad.lugar.id = :lugarId")
	public abstract List<Turno> findByServicioIdAndLugarId(int servicioId, int lugarId);
    
    @Query("SELECT t FROM Turno t WHERE " +
    	       "(:servicioId IS NULL OR t.dia.disponibilidad.servicio.id = :servicioId) AND " +
    	       "(:lugarId IS NULL OR t.dia.disponibilidad.lugar.id = :lugarId) AND " +
    	       "(:fechaInicio IS NULL OR t.dia.fecha >= :fechaInicio) AND " +
    	       "(:fechaFin IS NULL OR t.dia.fecha <= :fechaFin)")
    public abstract	List<Turno> buscarFiltrado(@Param("servicioId") Integer servicioId,
    	                            @Param("lugarId") Integer lugarId,
    	                            @Param("fechaInicio") LocalDate fechaInicio,
    	                            @Param("fechaFin") LocalDate fechaFin);
}
