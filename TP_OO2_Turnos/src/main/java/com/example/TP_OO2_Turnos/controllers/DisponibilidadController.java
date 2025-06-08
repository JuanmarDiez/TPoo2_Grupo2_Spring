package com.example.TP_OO2_Turnos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.TP_OO2_Turnos.models.DisponibilidadModel;
import com.example.TP_OO2_Turnos.services.IDisponibilidadService;
import com.example.TP_OO2_Turnos.services.ILugarService;
import com.example.TP_OO2_Turnos.services.IServicioService;

@Controller
@RequestMapping("/disponibilidades")
public class DisponibilidadController {
	@Autowired
	@Qualifier("disponibilidadService")
	private IDisponibilidadService disponibilidadService;
	
	@Autowired
	@Qualifier("lugarService")
	private ILugarService lugarService;
	
	@Autowired
	@Qualifier("servicioService")
	private IServicioService servicioService;
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("disponibilidad");
		mav.addObject("disponibilidades", disponibilidadService.getAll());
		mav.addObject("lugares", lugarService.getAll());
		mav.addObject("servicios", servicioService.getAll());
		mav.addObject("disponibilidad",new DisponibilidadModel());
		return mav;
	}
	
	@PostMapping("/")
	public RedirectView create(@ModelAttribute("disponibilidad") DisponibilidadModel disponibilidadModel) {
		disponibilidadService.insertOrUpdate(disponibilidadModel);
		return new RedirectView("/disponibilidades/");
	}
}
