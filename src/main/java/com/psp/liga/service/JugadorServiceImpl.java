package com.psp.liga.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psp.liga.models.Equipo;
import com.psp.liga.models.Jugador;
import com.psp.liga.repositories.IJugadorRepositorie;

@Service
public class JugadorServiceImpl implements IJugadorService {

    @Autowired
    IJugadorRepositorie jugadorRepositorie;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Jugador> findAll() {
        return jugadorRepositorie.findAll();
    }

    @Override
    public void saveJugador(Jugador jugador) {
        jugadorRepositorie.save(jugador);
    }

    @Override
    public Jugador findJugadorById(int id) {
        Optional<Jugador> jugador = jugadorRepositorie.findById(id);
        return jugador.get();

    }

    @Override
    public void deleteJugadorById(int id) {
        jugadorRepositorie.deleteById(id);
    }

    @Override
    public List<Jugador> findJugadoresByEquipo(Equipo equipo) {
        TypedQuery<Jugador> query = entityManager.createQuery("SELECT j FROM Jugador j WHERE j.equipo = :equipo",
                Jugador.class);
        query.setParameter("equipo", equipo);
        return query.getResultList();
    }
}
