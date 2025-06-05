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
import com.example.TP_OO2_Turnos.services.IClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	@Autowired
	@Qualifier("clienteService")
	private IClienteService clienteService;

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("cliente");
		mav.addObject("clientes", clienteService.getAll());
		mav.addObject("cliente",new ClienteModel());
		return mav;
	}
	
	@PostMapping("/")
	public RedirectView create(@ModelAttribute("cliente") ClienteModel clienteModel) {
		clienteService.insertOrUpdate(clienteModel);
		return new RedirectView("/clientes/");
	}
	
}
