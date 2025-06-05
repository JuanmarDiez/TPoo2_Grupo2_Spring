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

import com.example.TP_OO2_Turnos.models.ClienteModel;
import com.example.TP_OO2_Turnos.models.EmpleadoModel;
import com.example.TP_OO2_Turnos.services.IEmpleadoService;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {
	@Autowired
	@Qualifier("empleadoService")
	private IEmpleadoService empleadoService;

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("empleado");
		mav.addObject("empleados", empleadoService.getAll());
		mav.addObject("empleado",new EmpleadoModel());
		return mav;
	}
	
	@PostMapping("/")
	public RedirectView create(@ModelAttribute("empleado") EmpleadoModel empleadoModel) {
		empleadoService.insertOrUpdate(empleadoModel);
		return new RedirectView("/empleados/");
	}
}
