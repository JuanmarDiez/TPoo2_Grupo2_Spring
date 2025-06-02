package com.example.TP_OO2_Turnos.services;

import java.util.List;

import com.example.TP_OO2_Turnos.entities.Lugar;
import com.example.TP_OO2_Turnos.models.LugarModel;

public interface ILugarService {
	
    public List<Lugar> getAll();
    
    public LugarModel insertOrUpdate(LugarModel lugarModel);
    
    public boolean remove(int id);
}
