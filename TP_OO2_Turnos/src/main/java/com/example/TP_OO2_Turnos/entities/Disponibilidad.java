package com.example.TP_OO2_Turnos.entities;

import com.example.TP_OO2_Turnos.enums.DiaLaborable;
import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.Set;

@Entity
@Table(name = "disponibilidad")
public class Disponibilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "lugar_id", nullable = false)
    private Lugar lugar;

    @ManyToOne
    @JoinColumn(name = "servicio_id", nullable = false)
    private Servicio servicio;

    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "hora_fin", nullable = false)
    private LocalTime horaFin;

    @ElementCollection(targetClass = DiaLaborable.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "disponibilidad_dias_laborables", joinColumns = @JoinColumn(name = "disponibilidad_id"))
    @Column(name = "dia_laborable")
    private Set<DiaLaborable> diasLaborables;

    @ManyToMany(mappedBy = "disponibilidades")
    private Set<Dia> dias;

    public Disponibilidad() {}

    public Disponibilidad(int id, Lugar lugar, Servicio servicio, LocalTime horaInicio, LocalTime horaFin, Set<DiaLaborable> diasLaborables) {
        this.id = id;
        this.lugar = lugar;
        this.servicio = servicio;
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

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
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

    public Set<Dia> getDias() {
        return dias;
    }

    public void setDias(Set<Dia> dias) {
        this.dias = dias;
    }
}
