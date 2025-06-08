package com.example.TP_OO2_Turnos.controllers;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.TP_OO2_Turnos.entities.Disponibilidad;
import com.example.TP_OO2_Turnos.models.DiaModel;
import com.example.TP_OO2_Turnos.services.IDiaService;
import com.example.TP_OO2_Turnos.services.IDisponibilidadService;


@Controller
@RequestMapping("/dias")
public class DiaController {
	@Autowired
	@Qualifier("diaService")
	private IDiaService diaService;
	
	@Autowired
	@Qualifier("disponibilidadService")
	private IDisponibilidadService disponibilidadService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    binder.registerCustomEditor(Disponibilidad.class, new PropertyEditorSupport() {
	        @Override
	        public void setAsText(String id) {

	            Disponibilidad d = disponibilidadService.findById(Integer.parseInt(id));
	            setValue(d);
	        }
	    });
	}
	
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
		diaService.insertOrUpdate(diaModel);
		return new RedirectView("/dias/");
	}
}
