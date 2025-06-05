package com.example.TP_OO2_Turnos.controllers;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.TP_OO2_Turnos.enums.DiaLaborable;
import com.example.TP_OO2_Turnos.models.DiaModel;
import com.example.TP_OO2_Turnos.models.DisponibilidadModel;
import com.example.TP_OO2_Turnos.services.IDiaService;
import com.example.TP_OO2_Turnos.services.IDisponibilidadService;
import com.example.TP_OO2_Turnos.services.ILugarService;
import com.example.TP_OO2_Turnos.services.IServicioService;

@Controller
@RequestMapping("/dias")
public class DiaController {
	@Autowired
	@Qualifier("diaService")
	private IDiaService diaService;
	
	@Autowired
	@Qualifier("disponibilidadService")
	private IDisponibilidadService disponibilidadService;
	
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("dia");
		mav.addObject("dias", diaService.getAll());
		mav.addObject("disponibilidades",disponibilidadService.getAll());
		mav.addObject("dia",new DiaModel());
		return mav;
	}
	
	@PostMapping("/")
	public RedirectView create(@ModelAttribute("dia") DiaModel diaModel) {
		DiaLaborable diaSemanaEnum = DiaLaborable.valueOf(diaModel.getFecha().getDayOfWeek().name());
		if(diaModel.getDisponibilidades().stream().filter(d -> d.getDiasLaborables().contains(diaSemanaEnum)).collect(Collectors.toList()) != null) {
		diaService.insertOrUpdate(diaModel);
		}
		return new RedirectView("/dias/");
	}
}
