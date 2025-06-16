package com.example.TP_OO2_Turnos.repositories;

import java.io.Serializable;
import java.util.List;
import java.time.LocalTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TP_OO2_Turnos.entities.Disponibilidad;
import com.example.TP_OO2_Turnos.entities.Lugar;
import com.example.TP_OO2_Turnos.entities.Servicio;

@Repository("disponibilidadRepository")
public interface IDisponibilidadRepository extends JpaRepository<Disponibilidad, Serializable> {
    public abstract Disponibilidad findById(int id);
    public abstract List<Disponibilidad> findByLugarId(int lugarId);
    public abstract List<Disponibilidad> findByServicioId(int servicioId);
    
    boolean existsByLugarAndServicioAndHoraInicioAndHoraFin(
    	    Lugar lugar, Servicio servicio, LocalTime horaInicio, LocalTime horaFin
    	);
    
    Disponibilidad findByLugarAndServicioAndHoraInicioAndHoraFin(
    	    Lugar lugar, Servicio servicio, LocalTime horaInicio, LocalTime horaFin
    	);
   
}