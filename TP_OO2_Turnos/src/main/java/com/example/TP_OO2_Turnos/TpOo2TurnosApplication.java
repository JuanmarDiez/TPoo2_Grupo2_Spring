package com.example.TP_OO2_Turnos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.TP_OO2_Turnos.entities.Cliente;
import com.example.TP_OO2_Turnos.entities.Dia;
import com.example.TP_OO2_Turnos.entities.Disponibilidad;
import com.example.TP_OO2_Turnos.entities.Empleado;
import com.example.TP_OO2_Turnos.entities.Lugar;
import com.example.TP_OO2_Turnos.entities.Servicio;
import com.example.TP_OO2_Turnos.entities.Turno;
import com.example.TP_OO2_Turnos.entities.User;
import com.example.TP_OO2_Turnos.entities.UserRole;
import com.example.TP_OO2_Turnos.enums.DiaLaborable;
import com.example.TP_OO2_Turnos.repositories.IDiaRepository;
import com.example.TP_OO2_Turnos.repositories.IDisponibilidadRepository;
import com.example.TP_OO2_Turnos.repositories.ILugarRepository;
import com.example.TP_OO2_Turnos.repositories.IServicioRepository;
import com.example.TP_OO2_Turnos.repositories.ITurnoRepository;
import com.example.TP_OO2_Turnos.repositories.IUserRepository;
import com.example.TP_OO2_Turnos.repositories.IUserRoleRepository;
import com.example.TP_OO2_Turnos.repositories.IUsuarioRepository;
import com.example.TP_OO2_Turnos.services.implementation.DiaService;
import com.example.TP_OO2_Turnos.services.implementation.DisponibilidadService;
import com.example.TP_OO2_Turnos.services.implementation.LugarService;
import com.example.TP_OO2_Turnos.services.implementation.ServicioService;
import com.example.TP_OO2_Turnos.services.implementation.TurnoService;

@SpringBootApplication
public class TpOo2TurnosApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpOo2TurnosApplication.class, args);
	}
    
}
