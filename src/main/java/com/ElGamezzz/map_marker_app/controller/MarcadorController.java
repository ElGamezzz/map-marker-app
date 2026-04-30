package com.ElGamezzz.map_marker_app.controller;


import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ElGamezzz.map_marker_app.model.Marcador;
import com.ElGamezzz.map_marker_app.repository.MarcadorRepository;

@RestController
@RequestMapping("/api/marcadores")
@CrossOrigin(origins = "*") // Facilita pruebas locales
public class MarcadorController {

    private final MarcadorRepository repository;

    public MarcadorController(MarcadorRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Marcador> obtenerTodos() {
        return repository.findAll();
    }

    @PostMapping
    public Marcador guardar(@RequestBody Marcador marcador) {
        return repository.save(marcador);
    }
}