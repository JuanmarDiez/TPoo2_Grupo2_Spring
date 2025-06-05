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

import com.example.TP_OO2_Turnos.models.ServicioModel;
import com.example.TP_OO2_Turnos.services.IServicioService;

@Controller
@RequestMapping("/servicios")
public class ServicioController {
	
	@Autowired
	@Qualifier("servicioService")
	private IServicioService servicioService;
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("servicio");
		mav.addObject("servicios", servicioService.getAll());
		mav.addObject("servicio",new ServicioModel());
		return mav;
	}
	
	@PostMapping("/")
	public RedirectView create(@ModelAttribute("servicio") ServicioModel servicioModel) {
		servicioService.insertOrUpdate(servicioModel);
		return new RedirectView("/servicios/");
	}
}
