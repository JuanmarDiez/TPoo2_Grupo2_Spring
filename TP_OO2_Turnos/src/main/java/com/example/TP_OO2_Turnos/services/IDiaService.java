package com.example.TP_OO2_Turnos.services;

import java.time.LocalDate;
import java.util.List;

import com.example.TP_OO2_Turnos.entities.Dia;
import com.example.TP_OO2_Turnos.entities.Disponibilidad;
import com.example.TP_OO2_Turnos.models.DiaModel;

public interface IDiaService {
    
    public List<Dia> getAll();
    
    public DiaModel insertOrUpdate(DiaModel diaModel);
    
    public boolean remove(int id);
    
    public Dia findById(int id);
    
    public DiaModel findByFecha(LocalDate fecha);
    
    public List<DiaModel> findByFechaBetween(LocalDate inicio, LocalDate fin);
    
    public Dia findByFechaAndDisponibilidad(LocalDate fecha, Disponibilidad disponibilidad);
    
    //public DiaModel registrarDiaSiNoExiste(LocalDate fecha, Disponibilidad disponibilidad);

}