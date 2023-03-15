package com.psp.liga.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psp.liga.models.Equipo;
import com.psp.liga.repositories.IEquipoRepositorie;

@Service
public class EquipoServiceImpl implements IEquipoService {

    @Autowired
    IEquipoRepositorie equipoRepositorie;

    @Override
    public List<Equipo> findAll() {
        return equipoRepositorie.findAll();
    }

    @Override
    public void saveEquipo(Equipo equipo) {
        equipoRepositorie.save(equipo);
    }

    @Override
    public Equipo findEquipoById(int id) {
        Optional<Equipo> equipo = equipoRepositorie.findById(id);
        return equipo.get();
    }

    @Override
    public void deleteEquipoById(int id) {
        equipoRepositorie.deleteById(id);
    }

}
