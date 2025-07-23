package com.example.TP_OO2_Turnos.controllers.api.v1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.TP_OO2_Turnos.converters.EmpleadoConverter;
import com.example.TP_OO2_Turnos.entities.Empleado;
import com.example.TP_OO2_Turnos.dtos.EmpleadoDTO;
import com.example.TP_OO2_Turnos.models.EmpleadoModel;
import com.example.TP_OO2_Turnos.models.ServicioModel;
import com.example.TP_OO2_Turnos.services.IEmpleadoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/api/v1/empleados")
@Tag(name = "Empleados", description = "Operaciones relacionadas con los empleados del sistema")
public class EmpleadoRestController {

    @Autowired
    @Qualifier("empleadoService")
    private IEmpleadoService empleadoService;
    
    @Autowired
    @Qualifier("empleadoConverter")
    private EmpleadoConverter empleadoConverter;

    @GetMapping
    @Operation(summary = "Listar empleados")
    public ResponseEntity<List<EmpleadoDTO>> getAll() {
    	List<EmpleadoDTO> empleados= new ArrayList<EmpleadoDTO>();
    	List<Empleado> aux= empleadoService.getAll();
    	
    	for(int i=0;i<aux.size();i++) {
    		empleados.add(empleadoConverter.entityToDTO(aux.get(i)));
    	}
    	
    	return new ResponseEntity<List<EmpleadoDTO>>(empleados, HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Crear o editar empleado")
    public ResponseEntity<EmpleadoModel> create(@RequestBody EmpleadoModel model) {
        EmpleadoModel nuevo = empleadoService.insertOrUpdate(model);
        return ResponseEntity.ok(nuevo);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar empleado")
    public ResponseEntity<String> delete(@PathVariable int id) {
        boolean eliminado = empleadoService.remove(id);
        return eliminado
            ? ResponseEntity.ok("Empleado eliminado")
            : ResponseEntity.status(404).body("No se pudo eliminar");
    }

    @GetMapping("/{legajo}")
    @Operation(summary = "Buscar por legajo")
    public ResponseEntity<Empleado> find(@PathVariable int legajo) throws Exception {
        Empleado empleado = empleadoService.findByLegajo(legajo);
        return ResponseEntity.ok(empleado);
    }
}