package com.example.TP_OO2_Turnos.converters;

import org.springframework.stereotype.Component;

import com.example.TP_OO2_Turnos.entities.Servicio;
import com.example.TP_OO2_Turnos.models.ServicioModel;

@Component("servicioConverter")
public class ServicioConverter {

    public ServicioModel entityToModel(Servicio servicio) {
        return new ServicioModel(servicio.getId(), servicio.getNombreServicio(), servicio.getDuracionServicio());
    }

    public Servicio modelToEntity(ServicioModel model) {
        return new Servicio(model.getId(), model.getNombreServicio(), model.getDuracionServicio());
    }
}
