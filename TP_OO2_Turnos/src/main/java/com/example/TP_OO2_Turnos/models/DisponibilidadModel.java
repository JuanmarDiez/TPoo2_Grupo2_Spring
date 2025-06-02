package com.example.TP_OO2_Turnos.models;

import com.example.TP_OO2_Turnos.enums.DiaLaborable;

import java.time.LocalTime;
import java.util.Set;

public class DisponibilidadModel {

    private int id;
    private int idLugar;
    private int idServicio;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Set<DiaLaborable> diasLaborables;

    public DisponibilidadModel() {}

    public DisponibilidadModel(int id, int idLugar, int idServicio, LocalTime horaInicio, LocalTime horaFin, Set<DiaLaborable> diasLaborables) {
        this.id = id;
        this.idLugar = idLugar;
        this.idServicio = idServicio;
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

    public int getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(int idLugar) {
        this.idLugar = idLugar;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
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
