package com.example.TP_OO2_Turnos.controllers.api.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import com.example.TP_OO2_Turnos.dtos.LoginDTO;
import com.example.TP_OO2_Turnos.entities.Usuario;
import com.example.TP_OO2_Turnos.services.IUsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/api/v1/auth")
@Tag(name = "Autenticación", description = "Operaciones relacionadas con el login de usuarios")
public class AuthController {
	
	private final AuthenticationManager authenticationManager;

    public AuthController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO request) {
        try {
          
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password())
            );

           
            return ResponseEntity.ok("Autenticación exitosa.");

        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }
}