package com.example.TP_OO2_Turnos.controllers;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.TP_OO2_Turnos.entities.Empleado;
import com.example.TP_OO2_Turnos.entities.Usuario;
import com.example.TP_OO2_Turnos.exception.UnauthorizedException;
import com.example.TP_OO2_Turnos.models.ClienteModel;
import com.example.TP_OO2_Turnos.services.IClienteService;
import com.example.TP_OO2_Turnos.services.IDiaService;
import com.example.TP_OO2_Turnos.services.IDisponibilidadService;
import com.example.TP_OO2_Turnos.services.ILugarService;
import com.example.TP_OO2_Turnos.services.IServicioService;
import com.example.TP_OO2_Turnos.services.IUsuarioService;

@Controller
public class HomeController {
	
	@Autowired
	@Qualifier("diaService")
	private IDiaService diaService;
	
	
	@Autowired
    @Qualifier("usuarioService")
    private IUsuarioService usuarioService;
    
	
	@GetMapping("/")
	public RedirectView redirectToLogin() {
		return new RedirectView("/login");
	}
	
    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }
    
    @PostMapping("/login")
    public String loginSubmit(@RequestParam String email, 
                            @RequestParam String clave, 
                            Model model) {
        Usuario usuario = usuarioService.login(email, clave);
        if (usuario != null) {
            return "redirect:/index";
        } else {
        	throw new UnauthorizedException("Credenciales invalidas");
            //model.addAttribute("error", "Credenciales inválidas");
            //return "login";
        }
    }
    
    @GetMapping("/index")
    public String index() {
        return "index";
    }
}