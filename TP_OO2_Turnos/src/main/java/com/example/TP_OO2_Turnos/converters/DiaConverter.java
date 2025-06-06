package com.example.TP_OO2_Turnos.converters;

import org.springframework.stereotype.Component;

import com.example.TP_OO2_Turnos.entities.Dia;
import com.example.TP_OO2_Turnos.models.DiaModel;

@Component("diaConverter")
public class DiaConverter {

    public DiaModel entityToModel(Dia dia) {
        return new DiaModel(dia.getId(), dia.getFecha(), dia.getDisponibilidad());
    }

    public Dia modelToEntity(DiaModel model) {
        return new Dia(model.getId(), model.getFecha(), model.getDisponibilidad());
    }
}