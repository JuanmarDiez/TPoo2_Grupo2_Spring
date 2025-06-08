package com.example.TP_OO2_Turnos.repositories;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TP_OO2_Turnos.entities.Dia;

@Repository("diaRepository")
public interface IDiaRepository extends JpaRepository<Dia, Serializable> {
    public abstract Dia findById(int id);
    public abstract Dia findByFecha(LocalDate fecha);
    public abstract List<Dia> findByFechaBetween(LocalDate inicio, LocalDate fin);
	
}