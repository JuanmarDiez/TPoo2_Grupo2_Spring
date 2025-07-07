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

import com.example.TP_OO2_Turnos.converters.ServicioConverter;
import com.example.TP_OO2_Turnos.entities.Servicio;
import com.example.TP_OO2_Turnos.models.ServicioModel;
import com.example.TP_OO2_Turnos.services.IServicioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/servicios")
@Tag(name = "Servicios", description = "Operaciones relacionadas con los servicios del sistema")
public class ServicioRestController {

    @Autowired
    @Qualifier("servicioService")
    private IServicioService servicioService;
    
    @Autowired
    @Qualifier("servicioConverter")
    private ServicioConverter servicioConverter;

    @GetMapping
    @Operation(summary = "Listar servicios")
    public ResponseEntity<List<ServicioModel>> getAll() {
    	List<ServicioModel> servicios= new ArrayList<ServicioModel>();
    	List<Servicio> aux= servicioService.getAll();
    	
    	for(int i=0;i<aux.size();i++) {
    		servicios.add(servicioConverter.entityToModel(aux.get(i)));
    	}
    	
    	return new ResponseEntity<List<ServicioModel>>(servicios, HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Crear servicio")
    public ResponseEntity<ServicioModel> create(@RequestBody ServicioModel model) {
        ServicioModel nuevo = servicioService.insertOrUpdate(model);
        return ResponseEntity.ok(nuevo);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar Servicio")
    public ResponseEntity<String> delete(@PathVariable int id) {
        boolean eliminado = servicioService.remove(id);
        return eliminado
            ? ResponseEntity.ok("Servicio eliminado")
            : ResponseEntity.status(404).body("No se pudo eliminar");
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar por id")
    public ResponseEntity<Servicio> find(@PathVariable int id) throws Exception {
        Servicio Servicio = servicioService.findById(id);
        return ResponseEntity.ok(Servicio);
    }
}
