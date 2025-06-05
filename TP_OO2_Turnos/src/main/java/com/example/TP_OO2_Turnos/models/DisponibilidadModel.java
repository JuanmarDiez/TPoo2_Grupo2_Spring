package com.example.TP_OO2_Turnos.models;

import com.example.TP_OO2_Turnos.entities.Lugar;
import com.example.TP_OO2_Turnos.entities.Servicio;
import com.example.TP_OO2_Turnos.enums.DiaLaborable;

import java.time.LocalTime;
import java.util.Set;

public class DisponibilidadModel {

    private int id;
    private Lugar lugar;
    private Servicio servicio;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Set<DiaLaborable> diasLaborables;

    public DisponibilidadModel() {}

    public DisponibilidadModel(int id, Lugar Lugar, Servicio Servicio, LocalTime horaInicio, LocalTime horaFin, Set<DiaLaborable> diasLaborables) {
        this.id = id;
        this.lugar = Lugar;
        this.servicio = Servicio;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.diasLaborables = diasLaborables;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar Lugar) {
        this.lugar = Lugar;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public Set<DiaLaborable> getDiasLaborables() {
        return diasLaborables;
    }

    public void setDiasLaborables(Set<DiaLaborable> diasLaborables) {
        this.diasLaborables = diasLaborables;
    }
}
