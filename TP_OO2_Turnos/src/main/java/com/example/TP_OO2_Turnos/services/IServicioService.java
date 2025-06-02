package com.example.TP_OO2_Turnos.services;

import java.util.List;

import com.example.TP_OO2_Turnos.entities.Servicio;
import com.example.TP_OO2_Turnos.models.ServicioModel;

public interface IServicioService {
	
    public List<Servicio> getAll();
    
    public ServicioModel insertOrUpdate(ServicioModel servicioModel);
    
    public boolean remove(int id);
}
