package com.psp.liga.service;

import com.psp.liga.models.Equipo;
import com.psp.liga.models.Jugador;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IJugadorService {
    List<Jugador> findAll();

    void saveJugador(Jugador jugador);

    Jugador findJugadorById(int id);

    void deleteJugadorById(int id);

    @Query("SELECT j FROM Jugador j WHERE j.equipo = :equipo")
    List<Jugador> findJugadoresByEquipo(@Param("equipo") Equipo equipo);
}
