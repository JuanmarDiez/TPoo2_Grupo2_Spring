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

import com.example.TP_OO2_Turnos.models.TurnoModel;
import com.example.TP_OO2_Turnos.services.ITurnoService;

@Controller
@RequestMapping("/turnos")
public class TurnoController {
	@Autowired
	@Qualifier("turnoService")
	private ITurnoService turnoService;

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("turno");
		mav.addObject("turnos", turnoService.getAll());
		mav.addObject("turno",new TurnoModel());
		return mav;
	}
	
	@PostMapping("/")
	public RedirectView create(@ModelAttribute("turno") TurnoModel turnoModel) {
		turnoService.insertOrUpdate(turnoModel);
		return new RedirectView("/turnos/");
	}
}
