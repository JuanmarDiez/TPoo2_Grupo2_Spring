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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.TP_OO2_Turnos.entities.Dia;
import com.example.TP_OO2_Turnos.entities.Disponibilidad;
import com.example.TP_OO2_Turnos.models.DiaModel;
import com.example.TP_OO2_Turnos.models.TurnoModel;
import com.example.TP_OO2_Turnos.services.IClienteService;
import com.example.TP_OO2_Turnos.services.IDiaService;
import com.example.TP_OO2_Turnos.services.IDisponibilidadService;
import com.example.TP_OO2_Turnos.services.IEmpleadoService;
import com.example.TP_OO2_Turnos.services.ITurnoService;

@Controller
@RequestMapping("/generarTurno")
public class GenerarTurnoController {
	@Autowired
	@Qualifier("turnoService")
	private ITurnoService turnoService;
	
	@Autowired
	@Qualifier("diaService")
	private IDiaService diaService;
	
	@Autowired
	@Qualifier("disponibilidadService")
	private IDisponibilidadService disponibilidadService;
	
	@Autowired
	@Qualifier("empleadoService")
	private IEmpleadoService empleadoService;
	
	@Autowired
	@Qualifier("clienteService")
	private IClienteService clienteService;
	
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
	
	
	
	@GetMapping("/elegirDia")
	public ModelAndView elegirDia() {
		ModelAndView mav = new ModelAndView("turno/dia");
		mav.addObject("dias", diaService.getAll());
		mav.addObject("disponibilidades",disponibilidadService.getAll());
		mav.addObject("dia",new DiaModel());
		return mav;
	}
	
	@PostMapping("/elegirDia")
	public String createDia(@ModelAttribute("dia") DiaModel diaModel,RedirectAttributes redirectAttributes) {	
		diaModel = diaService.insertOrUpdate(diaModel);
		redirectAttributes.addAttribute("diaId", diaModel.getId());
		return "redirect:/generarTurno/turnos";
	}
	
	@GetMapping("/turnos")
	public ModelAndView turno(@RequestParam("diaId") int diaId) {
		ModelAndView mav = new ModelAndView("turno/turno");
		mav.addObject("dia", diaService.findById(diaId));
		mav.addObject("empleados",empleadoService.getAll());
		mav.addObject("clientes",clienteService.getAll());
		mav.addObject("turno",new TurnoModel());
		
		return mav;
	}
	
	@PostMapping("/turnos")
	public String createTurno(@ModelAttribute("turno") TurnoModel turnoModel) {
		turnoService.insertOrUpdate(turnoModel);
		return "redirect:/index";
	}

}
