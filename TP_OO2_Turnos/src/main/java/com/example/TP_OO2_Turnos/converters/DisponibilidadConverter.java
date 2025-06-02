package com.example.TP_OO2_Turnos.converters;

import org.springframework.stereotype.Component;

import com.example.TP_OO2_Turnos.entities.Disponibilidad;
import com.example.TP_OO2_Turnos.entities.Lugar;
import com.example.TP_OO2_Turnos.entities.Servicio;
import com.example.TP_OO2_Turnos.models.DisponibilidadModel;

@Component("disponibilidadConverter")
public class DisponibilidadConverter {

    public DisponibilidadModel entityToModel(Disponibilidad disponibilidad) {
        return new DisponibilidadModel(
            disponibilidad.getId(),
            disponibilidad.getLugar().getId(),
            disponibilidad.getServicio().getId(),
            disponibilidad.getHoraInicio(),
            disponibilidad.getHoraFin(),
            disponibilidad.getDiasLaborables()
        );
    }

    public Disponibilidad modelToEntity(DisponibilidadModel model, Lugar lugar, Servicio servicio) {
        return new Disponibilidad(
            model.getId(),
            lugar,
            servicio,
            model.getHoraInicio(),
            model.getHoraFin(),
            model.getDiasLaborables()
        );
    }
}