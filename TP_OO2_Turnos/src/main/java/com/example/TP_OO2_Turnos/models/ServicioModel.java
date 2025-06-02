package com.example.TP_OO2_Turnos.models;

public class ServicioModel {

    private int id;
    private String nombreServicio;
    private int duracionServicio;

    public ServicioModel() {}

    public ServicioModel(int id, String nombreServicio, int duracionServicio) {
        this.id = id;
        this.nombreServicio = nombreServicio;
        this.duracionServicio = duracionServicio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public int getDuracionServicio() {
        return duracionServicio;
    }

    public void setDuracionServicio(int duracionServicio) {
        this.duracionServicio = duracionServicio;
    }
}
