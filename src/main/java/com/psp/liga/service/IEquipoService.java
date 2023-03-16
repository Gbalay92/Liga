package com.psp.liga.service;

import com.psp.liga.models.Equipo;
import java.util.List;

public interface IEquipoService {
    List<Equipo> findAll();

    void saveEquipo(Equipo equipo);

    Equipo findEquipoById(int id);

    void deleteEquipoById(int id);


}
