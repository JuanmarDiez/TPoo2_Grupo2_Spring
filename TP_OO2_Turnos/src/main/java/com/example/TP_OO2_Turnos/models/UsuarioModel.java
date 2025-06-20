package com.example.TP_OO2_Turnos.models;


import com.example.TP_OO2_Turnos.entities.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class UsuarioModel {
	protected int id;
	
	protected User user;
	
	@Size(min=4, max=12)
	protected String nombre;
	
	@Size(min=4, max=12)
	protected String apellido;
	
	@Size(min=7, max=8)
	protected int dni;

	public UsuarioModel() {}
	
	public UsuarioModel(int id,String nombre,String apellido,int dni,User user) {
		this.id = id;
		this.nombre = nombre;
		this.dni = dni;
		this.user=user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "UsuarioModel [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + "]";
	}
	
	
	
}
