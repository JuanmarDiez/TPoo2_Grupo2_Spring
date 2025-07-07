package com.example.TP_OO2_Turnos.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.TP_OO2_Turnos.converters.ServicioConverter;
import com.example.TP_OO2_Turnos.entities.Cliente;
import com.example.TP_OO2_Turnos.entities.Servicio;
import com.example.TP_OO2_Turnos.models.ServicioModel;
import com.example.TP_OO2_Turnos.repositories.IServicioRepository;
import com.example.TP_OO2_Turnos.services.IServicioService;

@Service("servicioService")
public class ServicioService implements IServicioService {

    @Autowired
    @Qualifier("servicioRepository")
    private IServicioRepository servicioRepository;

    @Autowired
    @Qualifier("servicioConverter")
    private ServicioConverter servicioConverter;

    @Override
    public List<Servicio> getAll() {
        return servicioRepository.findAll();
    }

    @Override
    public ServicioModel insertOrUpdate(ServicioModel servicioModel) {
        Servicio servicio = servicioRepository.save(servicioConverter.modelToEntity(servicioModel));
        return servicioConverter.entityToModel(servicio);
    }

    @Override
    public boolean remove(int id) {
        try {
            servicioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public Servicio registrarServicioSiNoExiste(String nombreServicio, int duracion) {
        Servicio servicio = servicioRepository.findByNombreServicio(nombreServicio);
        
        if (servicio == null) {
            servicio = new Servicio();
            servicio.setNombreServicio(nombreServicio);
            servicio.setDuracionServicio(duracion);
            servicio = servicioRepository.save(servicio);
        }

        return servicio;
    }

	@Override
	public Servicio findById(int id) throws Exception {
		
		return servicioRepository.findById(id);
	}

}
