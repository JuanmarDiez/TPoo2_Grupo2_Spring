package com.example.TP_OO2_Turnos.controllers;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.TP_OO2_Turnos.models.ClienteModel;
import com.example.TP_OO2_Turnos.services.IClienteService;
import com.example.TP_OO2_Turnos.services.IDiaService;
import com.example.TP_OO2_Turnos.services.IDisponibilidadService;
import com.example.TP_OO2_Turnos.services.ILugarService;
import com.example.TP_OO2_Turnos.services.IServicioService;

@Controller
public class HomeController {
	
	@Autowired
	@Qualifier("diaService")
	private IDiaService diaService;

    @GetMapping("/home")
    public String home() {
    	
        return "home"; // Vista con las dos opciones
    }
    
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
    
    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }
    

}