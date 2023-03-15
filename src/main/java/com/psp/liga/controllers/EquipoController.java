package com.psp.liga.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psp.liga.models.Equipo;
import com.psp.liga.service.IEquipoService;
import com.psp.liga.service.IJugadorService;

@Controller
@RequestMapping("/equipos")
public class EquipoController {

    @Autowired
    IEquipoService equipoService;
    @Autowired
    IJugadorService jugadorService;

    @GetMapping("/create")
    public String createTeam(Equipo equipo) {
        return "equipos/formEquipo";
    }

    @GetMapping("/lista")
    public String getEquipos(Model model) {
        model.addAttribute("equipos", equipoService.findAll());
        return "equipos/listEquipo";
    }

    @GetMapping("/detalle/{id}")
    public String getJugadoresByEquipo(@PathVariable int id, Model model) {
        Equipo equipo = equipoService.findEquipoById(id);
        model.addAttribute("jugadores", jugadorService.findJugadoresByEquipo(equipo));
        return "jugadores/listJugador";
    }

    @PostMapping("/save")
    public String saveTeam(Equipo equipo) {
        equipoService.saveEquipo(equipo);
        return "redirect:/equipos/lista";
    }

    @GetMapping("/delete/{id}")
    public String deleteTeam(@PathVariable int id) {
        equipoService.deleteEquipoById(id);
        return "redirect:/equipos/lista";
    }
}
