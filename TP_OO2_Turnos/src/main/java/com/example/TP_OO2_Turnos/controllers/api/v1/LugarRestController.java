package com.example.TP_OO2_Turnos.controllers.api.v1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TP_OO2_Turnos.converters.LugarConverter;
import com.example.TP_OO2_Turnos.entities.Lugar;
import com.example.TP_OO2_Turnos.models.LugarModel;
import com.example.TP_OO2_Turnos.services.ILugarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/api/v1/lugares")
@Tag(name = "Lugares", description = "Operaciones relacionadas con los lugares del sistema")
public class LugarRestController {

    @Autowired
    @Qualifier("lugarService")
    private ILugarService lugarService;
    
    @Autowired
    @Qualifier("lugarConverter")
    private LugarConverter lugarConverter;

    @GetMapping
    @Operation(summary = "Listar lugaes")
    public ResponseEntity<List<LugarModel>> getAll() {
    	List<LugarModel> lugares= new ArrayList<LugarModel>();
    	List<Lugar> aux= lugarService.getAll();
    	
    	for(int i=0;i<aux.size();i++) {
    		lugares.add(lugarConverter.entityToModel(aux.get(i)));
    	}
    	
    	return new ResponseEntity<List<LugarModel>>(lugares, HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Crear o editar lugar")
    public ResponseEntity<LugarModel> create(@RequestBody LugarModel model) {
        LugarModel nuevo = lugarService.insertOrUpdate(model);
        return ResponseEntity.ok(nuevo);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar lugar")
    public ResponseEntity<String> delete(@PathVariable int id) {
        boolean eliminado = lugarService.remove(id);
        return eliminado
            ? ResponseEntity.ok("Lugar eliminado")
            : ResponseEntity.status(404).body("No se pudo eliminar");
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar por id")
    public ResponseEntity<Lugar> find(@PathVariable int id) throws Exception {
        Lugar Lugar = lugarService.findById(id);
        return ResponseEntity.ok(Lugar);
    }
}