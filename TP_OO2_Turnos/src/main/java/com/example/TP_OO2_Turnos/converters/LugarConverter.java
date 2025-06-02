package com.example.TP_OO2_Turnos.converters;

import org.springframework.stereotype.Component;

import com.example.TP_OO2_Turnos.entities.Lugar;
import com.example.TP_OO2_Turnos.models.LugarModel;

@Component("lugarConverter")
public class LugarConverter {

    public LugarModel entityToModel(Lugar lugar) {
        return new LugarModel(lugar.getId(), lugar.getCalle(), lugar.getLocalidad());
    }

    public Lugar modelToEntity(LugarModel model) {
        return new Lugar(model.getId(), model.getCalle(), model.getLocalidad());
    }
}
