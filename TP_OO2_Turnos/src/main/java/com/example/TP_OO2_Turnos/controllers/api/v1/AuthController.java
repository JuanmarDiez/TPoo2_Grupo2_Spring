package com.example.TP_OO2_Turnos.controllers.api.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.TP_OO2_Turnos.dtos.LoginDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/auth")
@Tag(name = "Autenticación", description = "Operaciones relacionadas con el login de usuarios")
public class AuthController {

    @PostMapping("/login")
    @Operation(summary = "Iniciar sesión", description = "Endpoint para login con username y password")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        // Lógica de autenticación (mock o real)
        return ResponseEntity.ok("Login exitoso para: " + loginDTO.username());
    }
}