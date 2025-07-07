package com.example.TP_OO2_Turnos.controllers.api.v1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TP_OO2_Turnos.converters.DisponibilidadConverter;
import com.example.TP_OO2_Turnos.converters.DisponibilidadConverter;
import com.example.TP_OO2_Turnos.entities.Disponibilidad;
import com.example.TP_OO2_Turnos.models.DisponibilidadModel;
import com.example.TP_OO2_Turnos.models.DisponibilidadModel;
import com.example.TP_OO2_Turnos.services.IDisponibilidadService;
import com.example.TP_OO2_Turnos.services.IDisponibilidadService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/disponibilidades")
@Tag(name = "Disponibilidad", description = "Operaciones relacionadas con las disponibilidades del sistema")
public class DisponibilidadRestController {

    @Autowired
    @Qualifier("disponibilidadService")
    private IDisponibilidadService disponibilidadService;
    
    @Autowired
    @Qualifier("disponibilidadConverter")
    private DisponibilidadConverter disponibilidadConverter;

    @GetMapping
    @Operation(summary = "Listar disponibilidades")
    public ResponseEntity<List<DisponibilidadModel>> getAll() {
    	List<DisponibilidadModel> disponibilidades= new ArrayList<DisponibilidadModel>();
    	List<Disponibilidad> aux= disponibilidadService.getAll();
    	
    	for(int i=0;i<aux.size();i++) {
    		disponibilidades.add(disponibilidadConverter.entityToModel(aux.get(i)));
    	}
    	
    	return new ResponseEntity<List<DisponibilidadModel>>(disponibilidades, HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Crear disponibilidad")
    public ResponseEntity<DisponibilidadModel> create(@RequestBody DisponibilidadModel model) {
        DisponibilidadModel nuevo = disponibilidadService.insertOrUpdate(model);
        return ResponseEntity.ok(nuevo);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar disponibilidad")
    public ResponseEntity<String> delete(@PathVariable int id) {
        boolean eliminado = disponibilidadService.remove(id);
        return eliminado
            ? ResponseEntity.ok("Disponibilidad eliminada")
            : ResponseEntity.status(404).body("No se pudo eliminar");
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar por id")
    public ResponseEntity<Disponibilidad> find(@PathVariable int id) throws Exception {
        Disponibilidad disponibilidad = disponibilidadService.findById(id);
        return ResponseEntity.ok(disponibilidad);
    }
}
