package com.example.TP_OO2_Turnos.models;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class UsuarioModel {
	protected int id;
	
	@Email
	protected String email;
	
	@Size(min=6)
	protected String clave;
	
	@Size(min=4, max=12)
	protected String nombre;
	
	@Size(min=4, max=12)
	protected String apellido;
	
	@Size(min=7, max=8)
	protected int dni;

	public UsuarioModel() {}
	
	public UsuarioModel(int id,String email,String clave,String nombre,String apellido,int dni) {
		this.id = id;
		this.email = email;
		this.clave = clave;
		this.nombre = nombre;
		this.dni = dni;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
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
	
	
}
