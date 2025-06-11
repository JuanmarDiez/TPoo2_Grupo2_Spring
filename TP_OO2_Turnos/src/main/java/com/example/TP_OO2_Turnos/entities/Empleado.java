package com.example.TP_OO2_Turnos.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="empleado")
@PrimaryKeyJoinColumn(name="usuario_id")
public class Empleado extends Usuario {
	
	@Column(name="legajo",nullable = false)
	private int legajo;
	
	@Column(name="fechaDeAlta")
	private LocalDate fechaDeAlta;
	
	@Column(name="esActivo")
	private boolean esActivo = true;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="empleado")
	private List<Turno> turnos;
	
	@Column(name="createdat")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="updatedat")
	@UpdateTimestamp
	private LocalDateTime updatedAt;

	public Empleado() {
	}

	public Empleado(int id, String nombre, String apellido, int dni, int legajo, LocalDate fechaDeAlta, boolean esActivo, User user) {
		super(id, nombre, apellido, dni, user);
		this.legajo=legajo;
		this.fechaDeAlta=fechaDeAlta;
		this.esActivo=esActivo;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public LocalDate getFechaDeAlta() {
		return fechaDeAlta;
	}

	public void setFechaDeAlta(LocalDate fechaDeAlta) {
		this.fechaDeAlta = fechaDeAlta;
	}

	public boolean isEsActivo() {
		return esActivo;
	}

	public void setEsActivo(boolean esActivo) {
		this.esActivo = esActivo;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}
	
	
	
}
