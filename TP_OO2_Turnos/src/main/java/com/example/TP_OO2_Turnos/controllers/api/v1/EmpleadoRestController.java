package com.example.TP_OO2_Turnos.controllers.api.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.TP_OO2_Turnos.entities.Empleado;
import com.example.TP_OO2_Turnos.models.EmpleadoModel;
import com.example.TP_OO2_Turnos.services.IEmpleadoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/empleados")
@Tag(name = "Empleados", description = "Operaciones relacionadas con los empleados del sistema")
public class EmpleadoRestController {

    @Autowired
    @Qualifier("empleadoService")
    private IEmpleadoService empleadoService;

    @GetMapping
    @Operation(summary = "Listar empleados")
    public ResponseEntity<List<Empleado>> getAll() {
        return ResponseEntity.ok(empleadoService.getAll());
    }

    @PostMapping
    @Operation(summary = "Crear empleado")
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