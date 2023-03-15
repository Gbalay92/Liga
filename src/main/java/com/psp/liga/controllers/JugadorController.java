package com.psp.liga.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psp.liga.models.Jugador;
import com.psp.liga.models.Equipo;
import com.psp.liga.service.IEquipoService;
import com.psp.liga.service.IJugadorService;

@Controller
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    IJugadorService jugadorService;
    @Autowired
    IEquipoService equipoService;

    @GetMapping("/create")
    public String createPlayer(Model model, Jugador jugador) {
        List<Equipo> equipos = equipoService.findAll();
        model.addAttribute("equipos", equipos);
        return "jugadores/formJugador";
    }

    @PostMapping("/save")
    public String savePlayer(Jugador jugador, BindingResult result) {
        System.out.println(jugador.getId());
        jugadorService.saveJugador(jugador);
        return "redirect:/jugadores/lista";
    }

    @GetMapping("/lista")
    public String getTabla(Model model) {
        List<Jugador> jugadores = jugadorService.findAll();
        model.addAttribute("jugadores", jugadores);
        return "jugadores/listJugador";
    }

    @GetMapping("/delete/{id}")
    public String deletePlayer(@PathVariable int id) {
        jugadorService.deleteJugadorById(id);
        return "redirect:/jugadores/lista";
    }

    @GetMapping("/edit/{id}")
    public String editPlayer(@PathVariable int id, Model model) {
        List<Equipo> equipos = equipoService.findAll();
        Jugador jugador = jugadorService.findJugadorById(id);
        model.addAttribute("equipos", equipos);
        model.addAttribute("jugador", jugador);
        return "jugadores/formJugador";
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
    }
}
