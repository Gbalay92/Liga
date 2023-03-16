package com.psp.liga.service;

import com.psp.liga.models.Equipo;
import com.psp.liga.repositories.IEquipoRepositorie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class EquipoServiceImplTest {

    @Mock
    IEquipoRepositorie equipoRepositorieMock;
    @InjectMocks
    EquipoServiceImpl equipoService;



    @Test
    void findAll() {

        Equipo e = new Equipo();
        e.setId(1);

        List<Equipo> equipos=new ArrayList<>(Arrays.asList(e));
        when(equipoRepositorieMock.findAll()).thenReturn(equipos);

        List<Equipo> result=equipoService.findAll();

        assertEquals(1, result.size());
    }



    @Test
    void findEquipoById() {
        Equipo e = new Equipo();
        e.setId(1);
        when(equipoRepositorieMock.findById(1)).thenReturn(Optional.of(e));
        Equipo result= equipoService.findEquipoById(1);
        assertEquals(1, result.getId());
    }


}