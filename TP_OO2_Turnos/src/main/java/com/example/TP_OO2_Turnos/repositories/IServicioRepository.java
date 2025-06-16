package com.example.TP_OO2_Turnos.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TP_OO2_Turnos.entities.Servicio;

@Repository("servicioRepository")
public interface IServicioRepository extends JpaRepository<Servicio, Serializable> {
    public abstract Servicio findById(int id);
    boolean existsByNombreServicio(String nombreServicio);
    Servicio findByNombreServicio(String nombreServicio);
}
