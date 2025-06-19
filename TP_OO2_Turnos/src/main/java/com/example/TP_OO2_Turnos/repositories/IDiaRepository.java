package com.example.TP_OO2_Turnos.repositories;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.TP_OO2_Turnos.entities.Dia;
import com.example.TP_OO2_Turnos.entities.Disponibilidad;
import com.example.TP_OO2_Turnos.models.DiaModel;

@Repository("diaRepository")
public interface IDiaRepository extends JpaRepository<Dia, Serializable> {
    public abstract Dia findById(int id);
    public abstract Dia findByFecha(LocalDate fecha);
    public abstract List<Dia> findByFechaBetween(LocalDate inicio, LocalDate fin);
    boolean existsByFechaAndDisponibilidad(LocalDate fecha, Disponibilidad disponibilidad);
    
    @Query("SELECT d FROM Dia d WHERE d.fecha = :fecha AND d.disponibilidad = :disponibilidad")
    Dia findByFechaAndDisponibilidad(@Param("fecha") LocalDate fecha, @Param("disponibilidad") Disponibilidad disponibilidad);
    
}