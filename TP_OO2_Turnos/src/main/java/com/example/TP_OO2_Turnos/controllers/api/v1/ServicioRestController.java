package com.example.TP_OO2_Turnos.controllers.api.v1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TP_OO2_Turnos.converters.ServicioConverter;
import com.example.TP_OO2_Turnos.entities.Servicio;
import com.example.TP_OO2_Turnos.models.ServicioModel;
import com.example.TP_OO2_Turnos.services.IServicioService;

@RestController
@RequestMapping("/api/v1/servicio")
public class ServicioRestController {
	
	@Autowired
	@Qualifier("servicioService")
	private IServicioService servicioService;
	
	@Autowired
	@Qualifier("servicioConverter")
	private ServicioConverter servicioConverter;

	@GetMapping("/all")
	public ResponseEntity<List<ServicioModel>> allServicios(){
		List<ServicioModel> servicios = new ArrayList<ServicioModel>();
		List<Servicio> aux = servicioService.getAll();
		for(int i=0;i<aux.size();i++) {
			servicios.add(servicioConverter.entityToModel(aux.get(i)));
		}
		return new ResponseEntity<List<ServicioModel>>(servicios, HttpStatus.OK);
	}
}
