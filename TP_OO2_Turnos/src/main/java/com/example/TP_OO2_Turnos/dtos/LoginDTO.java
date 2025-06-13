package com.example.TP_OO2_Turnos.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginDTO(
	    @Email @NotBlank String username,
	    @NotBlank String password
	) {}