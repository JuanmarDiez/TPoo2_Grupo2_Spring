package com.example.TP_OO2_Turnos.services;

import java.time.LocalTime;
import java.util.List;

import java.util.Set;


import com.example.TP_OO2_Turnos.entities.Disponibilidad;
import com.example.TP_OO2_Turnos.entities.Lugar;
import com.example.TP_OO2_Turnos.entities.Servicio;
import com.example.TP_OO2_Turnos.models.DisponibilidadModel;
import com.example.TP_OO2_Turnos.enums.DiaLaborable;


public interface IDisponibilidadService {
    
    public List<Disponibilidad> getAll();
    
    public DisponibilidadModel insertOrUpdate(DisponibilidadModel disponibilidadModel);
    
    public boolean remove(int id);
    
    public Disponibilidad findById(int id);
    
    public List<Disponibilidad> findByLugarId(int lugarId);
    
    public List<Disponibilidad> findByServicioId(int servicioId);
    
    public Disponibilidad registrarDisponibilidadSiNoExiste(LocalTime horaInicio, LocalTime horaFin, Lugar lugar, Servicio servicio, Set<DiaLaborable> diasLaborables);
        
}