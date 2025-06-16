package com.example.TP_OO2_Turnos.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TP_OO2_Turnos.entities.Lugar;

@Repository("lugarRepository")
public interface ILugarRepository extends JpaRepository<Lugar, Serializable> {
    public abstract Lugar findById(int id);
    boolean existsByCalleAndLocalidad(String calle, String localidad);
    Lugar findByCalleAndLocalidad(String calle, String localidad);
}
