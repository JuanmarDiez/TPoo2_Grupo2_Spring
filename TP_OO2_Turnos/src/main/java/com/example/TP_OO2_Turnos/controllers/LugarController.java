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

import com.example.TP_OO2_Turnos.models.LugarModel;
import com.example.TP_OO2_Turnos.services.ILugarService;

@Controller
@RequestMapping("/lugares")
public class LugarController {
	@Autowired
	@Qualifier("lugarService")
	private ILugarService lugarService;
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("lugar");
		mav.addObject("lugares", lugarService.getAll());
		mav.addObject("lugar",new LugarModel());
		return mav;
	}
	
	@PostMapping("/")
	public RedirectView create(@ModelAttribute("lugar") LugarModel lugarModel) {
		lugarService.insertOrUpdate(lugarModel);
		return new RedirectView("/lugares/");
	}
}
