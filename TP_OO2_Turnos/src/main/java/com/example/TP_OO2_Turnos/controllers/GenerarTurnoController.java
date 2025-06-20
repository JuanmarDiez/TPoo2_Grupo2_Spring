package com.example.TP_OO2_Turnos.controllers;

import java.beans.PropertyEditorSupport;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
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

import com.example.TP_OO2_Turnos.converters.DiaConverter;
import com.example.TP_OO2_Turnos.entities.Dia;
import com.example.TP_OO2_Turnos.entities.Disponibilidad;
import com.example.TP_OO2_Turnos.entities.Turno;
import com.example.TP_OO2_Turnos.exception.TurnoIgualException;
import com.example.TP_OO2_Turnos.models.DiaModel;
import com.example.TP_OO2_Turnos.models.EmailModel;
import com.example.TP_OO2_Turnos.models.TurnoModel;
import com.example.TP_OO2_Turnos.services.IClienteService;
import com.example.TP_OO2_Turnos.services.IDiaService;
import com.example.TP_OO2_Turnos.services.IDisponibilidadService;
import com.example.TP_OO2_Turnos.services.IEmailService;
import com.example.TP_OO2_Turnos.services.IEmpleadoService;
import com.example.TP_OO2_Turnos.services.ITurnoService;

@Controller
@PreAuthorize("hasRole('ROLE_USER')")
@RequestMapping("/generarTurno")
public class GenerarTurnoController {
	
	 @Value("${email.receiver}")
	    private String[] emailReceiver;
	
	@Autowired
	@Qualifier("turnoService")
	private ITurnoService turnoService;
	
	@Autowired
	@Qualifier("diaService")
	private IDiaService diaService;
	
	@Autowired
	@Qualifier("diaConverter")
	private DiaConverter diaConverter;
	
	@Autowired
	@Qualifier("disponibilidadService")
	private IDisponibilidadService disponibilidadService;
	
	@Autowired
	@Qualifier("empleadoService")
	private IEmpleadoService empleadoService;
	
	@Autowired
	@Qualifier("clienteService")
	private IClienteService clienteService;
	
	@Autowired
	@Qualifier("emailService")
    private IEmailService emailService;
	
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
		//Corroborar si existe una clase dia para evitar duplicacion
		Dia diaExistente = diaService.findByFechaAndDisponibilidad(diaModel.getFecha(), diaModel.getDisponibilidad());
		if(diaExistente == null) {
		diaModel = diaService.insertOrUpdate(diaModel);
		redirectAttributes.addAttribute("diaId", diaModel.getId());
		}
		else {
			DiaModel diaM = diaConverter.entityToModel(diaExistente);
			redirectAttributes.addAttribute("diaId", diaM.getId());
		}
		return "redirect:/generarTurno/turnos";
	}
	
	@GetMapping("/turnos")
	public ModelAndView turno(@RequestParam("diaId") int diaId) {
		
		//Creacion de la seleccion de turnos para evitar que se elija un turno no permitido
		List<LocalTime> horarios = new ArrayList<LocalTime>();
		Disponibilidad disponibilidad = disponibilidadService.findById(diaService.findById(diaId).getDisponibilidad().getId());
		//Corroborar que no haya un turno existente en ese dia y horario
		Turno turnoExistente;
	
		LocalTime i = disponibilidad.getHoraInicio();
		while (i.isBefore(disponibilidad.getHoraFin())) {
			
			turnoExistente = turnoService.findByDiaAndHora(diaService.findById(diaId), i);
			
			if(turnoExistente == null) {
				horarios.add(i);
			}
		    i = i.plusMinutes(disponibilidad.getServicio().getDuracionServicio());
		}
		
		
		ModelAndView mav = new ModelAndView("turno/turno");
		mav.addObject("dia", diaService.findById(diaId));
		mav.addObject("horarios",horarios);
		mav.addObject("empleados",empleadoService.getAll());
		mav.addObject("clientes",clienteService.getAll());
		mav.addObject("turno",new TurnoModel());
		
		return mav;
	}
	
	@PostMapping("/turnos")
	public String createTurno(@ModelAttribute("turno") TurnoModel turnoModel, RedirectAttributes redirectAttributes) {
		//Turno turnoAux = turnoService.buscarTurnoBD(turnoModel.getCliente().getNroCliente(), turnoModel.getEmpleado().getLegajo(), turnoModel.getHora(), diaService.findById(turnoModel.getDia()).getFecha(), diaService.findById(turnoModel.getDia()).getDisponibilidad().getServicio().getId(), diaService.findById(turnoModel.getDia()).getDisponibilidad().getServicio().getId());
		turnoService.insertOrUpdate(turnoModel);
		EmailModel email = new EmailModel();
		email.setToUser(emailReceiver);
		email.setSubject("Confirmacion de creacion de turno");
		email.setMessage("Confirmamos que tu turno para el dia " + diaService.findById(turnoModel.getDia()).getFecha()+ " a las " + turnoModel.getHora() + " ha sido realizado con exito");
		emailService.sendEmail(email.getToUser(), email.getSubject(), email.getMessage());
		return "/index";
		
	}
}
