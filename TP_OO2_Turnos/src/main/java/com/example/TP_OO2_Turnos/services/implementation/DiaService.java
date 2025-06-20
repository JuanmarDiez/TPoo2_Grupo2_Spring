package com.example.TP_OO2_Turnos.services.implementation;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.TP_OO2_Turnos.converters.DiaConverter;
import com.example.TP_OO2_Turnos.entities.Dia;
import com.example.TP_OO2_Turnos.entities.Disponibilidad;
import com.example.TP_OO2_Turnos.models.DiaModel;
import com.example.TP_OO2_Turnos.repositories.IDiaRepository;
import com.example.TP_OO2_Turnos.repositories.IDisponibilidadRepository;
import com.example.TP_OO2_Turnos.services.IDiaService;

@Service("diaService")
public class DiaService implements IDiaService {

    @Autowired
    @Qualifier("diaRepository")
    private IDiaRepository diaRepository;
    
    @Autowired
    @Qualifier("disponibilidadRepository")
    private IDisponibilidadRepository disponibilidadRepository;

    @Autowired
    @Qualifier("diaConverter")
    private DiaConverter diaConverter;

    @Override
    public List<Dia> getAll() {
        return diaRepository.findAll();
    }

    @Override
    public DiaModel insertOrUpdate(DiaModel diaModel) {
        Dia dia = diaRepository.save(diaConverter.modelToEntity(diaModel));
        return diaConverter.entityToModel(dia);
    }

    @Override
    public boolean remove(int id) {
        try {
            diaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public DiaModel findByFecha(LocalDate fecha) {
        Dia dia = diaRepository.findByFecha(fecha);
        return dia != null ? diaConverter.entityToModel(dia) : null;
    }

    @Override
    public List<DiaModel> findByFechaBetween(LocalDate inicio, LocalDate fin) {
        return diaRepository.findByFechaBetween(inicio, fin)
                .stream()
                .map(dia -> diaConverter.entityToModel(dia))
                .collect(Collectors.toList());
    }

	@Override
	public Dia findById(int id) {
		return diaRepository.findById(id);
	}
    
   /* public DiaModel registrarDiaSiNoExiste(LocalDate fecha, Disponibilidad disponibilidad) {
        DiaModel dia = diaRepository.findByFechaAndDisponibilidad(fecha, disponibilidad);
        if (dia == null) {
            dia = new DiaModel();
            dia.setFecha(fecha);
            dia.setDisponibilidad(disponibilidad);
            dia = diaRepository.save(dia);
        }
        return dia;
    }*/

	@Override
	public Dia findByFechaAndDisponibilidad(LocalDate fecha, Disponibilidad disponibilidad) {
		return diaRepository.findByFechaAndDisponibilidad(fecha, disponibilidad);
	}

    
}
    
