package com.example.TP_OO2_Turnos.models;

import java.time.LocalDate;

public class DiaModel {

    private int id;
    private LocalDate fecha;

    public DiaModel() {}

    public DiaModel(int id, LocalDate fecha) {
        this.id = id;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}