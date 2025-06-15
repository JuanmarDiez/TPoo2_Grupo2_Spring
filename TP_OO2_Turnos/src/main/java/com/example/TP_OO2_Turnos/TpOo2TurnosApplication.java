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

@SpringBootApplication
public class TpOo2TurnosApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpOo2TurnosApplication.class, args);
	}

	/*
	@Bean
    public CommandLineRunner loadData(IUsuarioRepository usuarioRepository,IServicioRepository servicioRepository,ILugarRepository lugarRepository,
    		IDisponibilidadRepository disponibilidadRepository,IDiaRepository diaRepository, ITurnoRepository turnoRepository, IUserRepository userRepository,
    		IUserRoleRepository userRoleRepository) {
        return args -> {
        	
        	
            // Crear empleados de prueba
        	User user1 = new User();
        	 user1.setEmail("empleado1@empresa.com");
             user1.setClave("$2a$10$Z1nZ4qyoC5MEIhGmZeHN5O/c0v.hC6FoWEic3oF.Fyc/QMFJTdOxu");
             user1.setEnabled(true);
             userRepository.save(user1);
        	
            
            UserRole ur1 = new UserRole();
            ur1.setRole("ROLE_ADMIN");
            ur1.setUser(user1);
            userRoleRepository.save(ur1);
            
            Empleado empleado1 = new Empleado();
            empleado1.setNombre("Juan");
            empleado1.setApellido("Perez");
            empleado1.setDni(12345678);
            empleado1.setLegajo(1001);
            empleado1.setFechaDeAlta(LocalDate.now());
            empleado1.setEsActivo(true);
            empleado1.setUser(user1);
            usuarioRepository.save(empleado1);
            
            user1.setUsuario(empleado1);
            user1.getUserRoles().add(ur1);
            userRepository.save(user1);
            
            
            User user2 = new User();
            user2.setEmail("empleado2@empresa.com");
            user2.setClave("$2a$10$Z1nZ4qyoC5MEIhGmZeHN5O/c0v.hC6FoWEic3oF.Fyc/QMFJTdOxu");
            user2.setEnabled(true);
            userRepository.save(user2);
            
            
            UserRole ur2 = new UserRole();
            ur2.setRole("ROLE_ADMIN");
            ur2.setUser(user2);
            userRoleRepository.save(ur2);
            
            Empleado empleado2 = new Empleado();
            empleado2.setNombre("Maria");
            empleado2.setApellido("Gomez");
            empleado2.setDni(23456789);
            empleado2.setLegajo(1002);
            empleado2.setFechaDeAlta(LocalDate.now());
            empleado2.setEsActivo(true);
            empleado2.setUser(user2);
            usuarioRepository.save(empleado2);
            
            user2.setUsuario(empleado2);
            user2.getUserRoles().add(ur2);
            userRepository.save(user2);
            
            // Crear clientes de prueba
                       
            User user3 = new User();
            user3.setEmail("cliente1@gmail.com");
            user3.setClave("$2a$10$Z1nZ4qyoC5MEIhGmZeHN5O/c0v.hC6FoWEic3oF.Fyc/QMFJTdOxu");
            user3.setEnabled(true);          
            userRepository.save(user3);
           
            UserRole ur3 = new UserRole();
            ur3.setRole("ROLE_USER");
            ur3.setUser(user3);
            userRoleRepository.save(ur3);
            
    
            Cliente cliente1 = new Cliente();
            cliente1.setNombre("Carlos");
            cliente1.setApellido("Lopez");
            cliente1.setDni(34567890);
            cliente1.setNroCliente(2001);
            cliente1.setUser(user3);
            usuarioRepository.save(cliente1);
            
            user3.setUsuario(cliente1);
            user3.getUserRoles().add(ur3);
            userRepository.save(user3);
            
            
            User user4 = new User();
            user4.setEmail("cliente2@gmail.com");
            user4.setClave("$2a$10$Z1nZ4qyoC5MEIhGmZeHN5O/c0v.hC6FoWEic3oF.Fyc/QMFJTdOxu");
            user4.setEnabled(true);
            userRepository.save(user4);
            
            
            UserRole ur4 = new UserRole();
            ur4.setRole("ROLE_USER");
            ur4.setUser(user4);
            userRoleRepository.save(ur4);
            
            Cliente cliente2 = new Cliente();
            cliente2.setNombre("Ana");
            cliente2.setApellido("Martinez");
            cliente2.setDni(45678901);
            cliente2.setNroCliente(2002);
            cliente2.setUser(user4);
            usuarioRepository.save(cliente2);
            
            user4.setUsuario(cliente2);
            user4.getUserRoles().add(ur4);
            userRepository.save(user4);
	
            
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
