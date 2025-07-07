package com.example.TP_OO2_Turnos.converters;

import org.springframework.stereotype.Component;

import com.example.TP_OO2_Turnos.entities.Disponibilidad;
import com.example.TP_OO2_Turnos.models.DisponibilidadModel;

@Component("disponibilidadConverter")
public class DisponibilidadConverter {

    public DisponibilidadModel entityToModel(Disponibilidad disponibilidad) {
        return new DisponibilidadModel(
            disponibilidad.getId(),
            disponibilidad.getLugar(),
            disponibilidad.getServicio(),
            disponibilidad.getHoraInicio(),
            disponibilidad.getHoraFin(),
            disponibilidad.getDiasLaborables(),
            disponibilidad.getDias()
        );
    }

    public Disponibilidad modelToEntity(DisponibilidadModel model) {
        return new Disponibilidad(
            model.id(),
            model.lugar(),
            model.servicio(),
            model.horaInicio(),
            model.horaFin(),
            model.diasLaborables()
        );
    }
}