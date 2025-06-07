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
import com.example.TP_OO2_Turnos.entities.Usuario;
import com.example.TP_OO2_Turnos.enums.DiaLaborable;
import com.example.TP_OO2_Turnos.repositories.IDiaRepository;
import com.example.TP_OO2_Turnos.repositories.IDisponibilidadRepository;
import com.example.TP_OO2_Turnos.repositories.ILugarRepository;
import com.example.TP_OO2_Turnos.repositories.IServicioRepository;
import com.example.TP_OO2_Turnos.repositories.ITurnoRepository;
import com.example.TP_OO2_Turnos.repositories.IUsuarioRepository;

@SpringBootApplication
public class TpOo2TurnosApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpOo2TurnosApplication.class, args);
	}
	/*
	@Bean
    public CommandLineRunner loadData(IUsuarioRepository usuarioRepository,IServicioRepository servicioRepository,ILugarRepository lugarRepository,
    		IDisponibilidadRepository disponibilidadRepository,IDiaRepository diaRepository, ITurnoRepository turnoRepository) {
        return args -> {
            // Crear empleados de prueba
            Empleado empleado1 = new Empleado();
            empleado1.setEmail("empleado1@empresa.com");
            empleado1.setClave("1234");
            empleado1.setNombre("Juan");
            empleado1.setApellido("Perez");
            empleado1.setDni(12345678);
            empleado1.setLegajo(1001);
            empleado1.setFechaDeAlta(LocalDate.now());
            empleado1.setEsActivo(true);
            
            Empleado empleado2 = new Empleado();
            empleado2.setEmail("empleado2@empresa.com");
            empleado2.setClave("1234");
            empleado2.setNombre("Maria");
            empleado2.setApellido("Gomez");
            empleado2.setDni(23456789);
            empleado2.setLegajo(1002);
            empleado2.setFechaDeAlta(LocalDate.now());
            empleado2.setEsActivo(true);
            
            // Crear clientes de prueba
            Cliente cliente1 = new Cliente();
            cliente1.setEmail("cliente1@gmail.com");
            cliente1.setClave("1234");
            cliente1.setNombre("Carlos");
            cliente1.setApellido("Lopez");
            cliente1.setDni(34567890);
            cliente1.setNroCliente(2001);
            
            Cliente cliente2 = new Cliente();
            cliente2.setEmail("cliente2@gmail.com");
            cliente2.setClave("1234");
            cliente2.setNombre("Ana");
            cliente2.setApellido("Martinez");
            cliente2.setDni(45678901);
            cliente2.setNroCliente(2002);
            
            // Guardar usuarios
            usuarioRepository.save(empleado1);
            usuarioRepository.save(empleado2);
            usuarioRepository.save(cliente1);
            usuarioRepository.save(cliente2);
            
          //crear Servicios de prueba
            Servicio servicio1 = new Servicio();
            servicio1.setDuracionServicio(15);
            servicio1.setNombreServicio("Limpieza dental");
            
            Servicio servicio2 = new Servicio();
            servicio2.setDuracionServicio(30);
            servicio2.setNombreServicio("Operacion conducto");
            
            //guardar servicios 
            servicioRepository.save(servicio1);
            servicioRepository.save(servicio2);
            
            //crear lugares de prueba
            Lugar lugar1 = new Lugar();
            lugar1.setCalle("pedro dreyer 26");
            lugar1.setLocalidad("Temperley");
            
            Lugar lugar2 = new Lugar();
            lugar2.setCalle("Rojas 123");
            lugar2.setLocalidad("Lomas de zamora");
            
            //guardar lugares
            lugarRepository.save(lugar1);
            lugarRepository.save(lugar2);
            
            //crear disponibilidades
            
            Set<DiaLaborable> dl= new HashSet<>();
            dl.add(DiaLaborable.LUNES);
            dl.add(DiaLaborable.MARTES);
            dl.add(DiaLaborable.MIERCOLES);
            dl.add(DiaLaborable.JUEVES);
            dl.add(DiaLaborable.VIERNES);
            
            Disponibilidad dis1 = new Disponibilidad();
            dis1.setHoraInicio(LocalTime.of(8, 0));
            dis1.setHoraFin(LocalTime.of(17, 0));
            dis1.setLugar(lugar1);
            dis1.setServicio(servicio1);
            dis1.setDiasLaborables(dl);
            
            Disponibilidad dis2 = new Disponibilidad();
            dis2.setHoraInicio(LocalTime.of(9, 0));
            dis2.setHoraFin(LocalTime.of(19, 0));
            dis2.setLugar(lugar2);
            dis2.setServicio(servicio2);
            dis2.setDiasLaborables(dl);
            
            //guardar disponibilidades
            disponibilidadRepository.save(dis1);
            disponibilidadRepository.save(dis2);
            
            //crear dias
            Dia dia1 = new Dia();
            dia1.setFecha(LocalDate.of(2025, 6, 7));
            dia1.setDisponibilidad(dis1);
            
            Dia dia2 = new Dia();
            dia2.setFecha(LocalDate.of(2025, 6, 10));
            dia2.setDisponibilidad(dis1);
            
            Dia dia3 = new Dia();
            dia3.setFecha(LocalDate.of(2025, 6, 17));
            dia3.setDisponibilidad(dis2);
            
            //Guardar dias
            diaRepository.save(dia1);
            diaRepository.save(dia2);
            diaRepository.save(dia3);
            
            //crear turno
            Turno turno1 = new Turno();
            turno1.setCliente(cliente1);
            turno1.setEmpleado(empleado1);
            turno1.setDia(dia1);
            turno1.setHora(LocalTime.of(15, 0));
            
            Turno turno2 = new Turno();
            turno2.setCliente(cliente1);
            turno2.setEmpleado(empleado2);
            turno2.setDia(dia2);
            turno2.setHora(LocalTime.of(11, 0));
            
            Turno turno3 = new Turno();
            turno3.setCliente(cliente2);
            turno3.setEmpleado(empleado1);
            turno3.setDia(dia3);
            turno3.setHora(LocalTime.of(13, 0));
            
            //guardar turnos
            turnoRepository.save(turno1);
            turnoRepository.save(turno2);
            turnoRepository.save(turno3);
        };
    }
    */
}
