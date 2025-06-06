package com.example.TP_OO2_Turnos;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.TP_OO2_Turnos.entities.Cliente;
import com.example.TP_OO2_Turnos.entities.Empleado;
import com.example.TP_OO2_Turnos.entities.Usuario;
import com.example.TP_OO2_Turnos.repositories.IUsuarioRepository;

@SpringBootApplication
public class TpOo2TurnosApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpOo2TurnosApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner loadData(IUsuarioRepository usuarioRepository) {
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
        };
    }
}
