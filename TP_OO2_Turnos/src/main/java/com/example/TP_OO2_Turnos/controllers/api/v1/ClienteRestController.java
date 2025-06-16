package com.example.TP_OO2_Turnos.controllers.api.v1;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.TP_OO2_Turnos.converters.ClienteConverter;
import com.example.TP_OO2_Turnos.dtos.ClienteDTO;
import com.example.TP_OO2_Turnos.entities.Cliente;
import com.example.TP_OO2_Turnos.entities.Empleado;
import com.example.TP_OO2_Turnos.models.ClienteModel;
import com.example.TP_OO2_Turnos.models.EmpleadoModel;
import com.example.TP_OO2_Turnos.services.IClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/clientes")
@Tag(name = "Clientes", description = "Operaciones relacionadas con los clientes del sistema")
public class ClienteRestController {
	@Autowired
    @Qualifier("clienteService")
    private IClienteService clienteService;

	@Autowired
    @Qualifier("clienteConverter")
    private ClienteConverter clienteConverter;

	
    @GetMapping
    @Operation(summary = "Listar clientes")
    public ResponseEntity<List<ClienteModel>> getAll() {
    	List<ClienteModel> clientes= new ArrayList<ClienteModel>();
    	List<Cliente> aux= clienteService.getAll();
    	
    	for(int i=0;i<aux.size();i++) {
    		clientes.add(clienteConverter.entityToModel(aux.get(i)));
    	}
    	
    	return new ResponseEntity<List<ClienteModel>>(clientes, HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Crear cliente")
    public ResponseEntity<ClienteModel> create(@RequestBody ClienteModel model) {
        ClienteModel nuevo = clienteService.insertOrUpdate(model);
        return ResponseEntity.ok(nuevo);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar cliente")
    public ResponseEntity<String> delete(@PathVariable int id) {
        boolean eliminado = clienteService.remove(id);
        return eliminado
            ? ResponseEntity.ok("Cliente eliminado")
            : ResponseEntity.status(404).body("No se pudo eliminar");
    }

    @GetMapping("/{nroCliente}")
    @Operation(summary = "Buscar por nroCliente")
    public ResponseEntity<Cliente> find(@PathVariable int nroCliente) throws Exception {
        Cliente cliente = clienteService.findByNroCliente(nroCliente);
        return ResponseEntity.ok(cliente);
    }
}
