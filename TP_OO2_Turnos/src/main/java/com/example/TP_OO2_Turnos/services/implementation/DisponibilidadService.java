package com.example.TP_OO2_Turnos.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.TP_OO2_Turnos.converters.DisponibilidadConverter;
import com.example.TP_OO2_Turnos.entities.Disponibilidad;
import com.example.TP_OO2_Turnos.entities.Lugar;
import com.example.TP_OO2_Turnos.entities.Servicio;
import com.example.TP_OO2_Turnos.models.DisponibilidadModel;
import com.example.TP_OO2_Turnos.repositories.IDisponibilidadRepository;
import com.example.TP_OO2_Turnos.repositories.ILugarRepository;
import com.example.TP_OO2_Turnos.repositories.IServicioRepository;
import com.example.TP_OO2_Turnos.services.IDisponibilidadService;

@Service("disponibilidadService")
public class DisponibilidadService implements IDisponibilidadService {

    @Autowired
    @Qualifier("disponibilidadRepository")
    private IDisponibilidadRepository disponibilidadRepository;

    @Autowired
    @Qualifier("disponibilidadConverter")
    private DisponibilidadConverter disponibilidadConverter;

    @Autowired
    @Qualifier("lugarRepository")
    private ILugarRepository lugarRepository;

    @Autowired
    @Qualifier("servicioRepository")
    private IServicioRepository servicioRepository;

    @Override
    public List<Disponibilidad> getAll() {
        return disponibilidadRepository.findAll();
    }

    @Override
    public DisponibilidadModel insertOrUpdate(DisponibilidadModel disponibilidadModel) {        
        Disponibilidad disponibilidad = disponibilidadRepository.save(disponibilidadConverter.modelToEntity(disponibilidadModel));
        return disponibilidadConverter.entityToModel(disponibilidad);
    }

    @Override
    public boolean remove(int id) {
        try {
            disponibilidadRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Disponibilidad> findByLugarId(int lugarId) {
        return disponibilidadRepository.findByLugarId(lugarId);
    }

    @Override
    public List<Disponibilidad> findByServicioId(int servicioId) {
        return disponibilidadRepository.findByServicioId(servicioId);
    }
}