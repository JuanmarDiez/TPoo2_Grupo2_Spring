package com.example.TP_OO2_Turnos.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmpleadoDTO(
    @NotBlank String nombre,
    @NotBlank String apellido,
    @Email @NotBlank String email,
    @NotBlank String clave,
    @NotBlank String dni,
    @NotNull LocalDate fechaDeAlta,
    @NotNull Boolean esActivo
) {}