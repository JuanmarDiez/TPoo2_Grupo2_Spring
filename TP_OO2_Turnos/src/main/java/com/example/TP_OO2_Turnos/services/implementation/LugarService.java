package com.example.TP_OO2_Turnos.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.TP_OO2_Turnos.converters.LugarConverter;
import com.example.TP_OO2_Turnos.entities.Lugar;
import com.example.TP_OO2_Turnos.models.LugarModel;
import com.example.TP_OO2_Turnos.repositories.ILugarRepository;
import com.example.TP_OO2_Turnos.services.ILugarService;

@Service("lugarService")
public class LugarService implements ILugarService {

    @Autowired
    @Qualifier("lugarRepository")
    private ILugarRepository lugarRepository;

    @Autowired
    @Qualifier("lugarConverter")
    private LugarConverter lugarConverter;

    @Override
    public List<Lugar> getAll() {
        return lugarRepository.findAll();
    }

    @Override
    public LugarModel insertOrUpdate(LugarModel lugarModel) {
        Lugar lugar = lugarRepository.save(lugarConverter.modelToEntity(lugarModel));
        return lugarConverter.entityToModel(lugar);
    }

    @Override
    public boolean remove(int id) {
        try {
            lugarRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

	@Override
	public Lugar findById(int id) {
		return lugarRepository.findById(id);
	}
}
