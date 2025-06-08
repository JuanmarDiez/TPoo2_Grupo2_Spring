package com.example.TP_OO2_Turnos.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.TP_OO2_Turnos.entities.Turno;
import com.example.TP_OO2_Turnos.services.IClienteService;
import com.example.TP_OO2_Turnos.services.IDiaService;
import com.example.TP_OO2_Turnos.services.IDisponibilidadService;
import com.example.TP_OO2_Turnos.services.IEmpleadoService;
import com.example.TP_OO2_Turnos.services.ILugarService;
import com.example.TP_OO2_Turnos.services.IServicioService;
import com.example.TP_OO2_Turnos.services.ITurnoService;

@Controller
@RequestMapping("/consultarTurnos")
public class ConsultarTurnoController {
	
	@Autowired
	@Qualifier("turnoService")
	private ITurnoService turnoService;
	
	@Autowired
	@Qualifier("diaService")
	private IDiaService diaService;
	
	@Autowired
	@Qualifier("disponibilidadService")
	private IDisponibilidadService disponibilidadService;
	
	@Autowired
	@Qualifier("empleadoService")
	private IEmpleadoService empleadoService;
	
	@Autowired
	@Qualifier("clienteService")
	private IClienteService clienteService;
	
	@Autowired
	@Qualifier("servicioService")
	private IServicioService servicioService;
	
	@Autowired
	@Qualifier("lugarService")
	private ILugarService lugarService;
	
	@GetMapping("/filtrar")
	public ModelAndView filtrar(@RequestParam(required = false) Integer servicioId,
            @RequestParam(required = false) Integer lugarId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {
		
		List<Turno>	turnos = turnoService.filtrarTurnos(servicioId, lugarId, fechaInicio, fechaFin);
		

	    ModelAndView mav = new ModelAndView("turno/filtros");
	    mav.addObject("turnos", turnos);
	    mav.addObject("servicios",servicioService.getAll());
	    mav.addObject("lugares",lugarService.getAll());
	    
	    return mav;
	}
}
