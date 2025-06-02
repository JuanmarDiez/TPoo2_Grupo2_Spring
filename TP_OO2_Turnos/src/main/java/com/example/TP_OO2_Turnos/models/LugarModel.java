package com.example.TP_OO2_Turnos.models;

public class LugarModel {

    private int id;
    private String calle;
    private String localidad;

    public LugarModel() {}

    public LugarModel(int id, String calle, String localidad) {
        this.id = id;
        this.calle = calle;
        this.localidad = localidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
}
