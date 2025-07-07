package com.example.TP_OO2_Turnos.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClienteDTO(
	@NotBlank int id,
    @NotBlank String nombre,
    @NotBlank String apellido,
    @Email @NotBlank String email,
    @NotBlank String clave,
    @NotBlank int dni,
    @NotBlank int nroCliente
) {}