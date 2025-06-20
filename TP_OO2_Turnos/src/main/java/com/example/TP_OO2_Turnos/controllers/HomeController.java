package com.example.TP_OO2_Turnos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.TP_OO2_Turnos.services.IDiaService;
import com.example.TP_OO2_Turnos.services.IUsuarioService;

@Controller
public class HomeController {
	
	@Autowired
	@Qualifier("diaService")
	private IDiaService diaService;
	
	
	@Autowired
    @Qualifier("usuarioService")
    private IUsuarioService usuarioService;
    
    
    @GetMapping("/index")
    public String index() {
        return "index";
    }
}