package com.example.TP_OO2_Turnos.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "dia")
public class Dia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fecha", nullable = false, unique = true)
    private LocalDate fecha;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "disponibilidad_dia",
        joinColumns = @JoinColumn(name = "dia_id"),
        inverseJoinColumns = @JoinColumn(name = "disponibilidad_id")
    )
    private Set<Disponibilidad> disponibilidades;

    public Dia() {}

    public Dia(int id, LocalDate fecha) {
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

    public Set<Disponibilidad> getDisponibilidades() {
        return disponibilidades;
    }

    public void setDisponibilidades(Set<Disponibilidad> disponibilidades) {
        this.disponibilidades = disponibilidades;
    }
}