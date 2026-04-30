package com.ElGamezzz.map_marker_app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ElGamezzz.map_marker_app.model.Marcador;
import com.ElGamezzz.map_marker_app.repository.MarcadorRepository;

/**
 * REST Controller: Expone la capa de presentación de la API.
 * - Usa inyección por constructor (práctica recomendada por Spring para inmutabilidad y testeo).
 * - Implementa el contrato REST: GET (lectura), POST (creación), DELETE (eliminación).
 * - @CrossOrigin("*") habilita CORS para desarrollo local. En producción, se restringe al dominio real.
 */
@RestController
@RequestMapping("/api/marcadores")
@CrossOrigin(origins = "*")
public class MarcadorController {

    private final MarcadorRepository repository;

    public MarcadorController(MarcadorRepository repository) {
        this.repository = repository;
    }

    /** GET /api/marcadores -> Devuelve lista completa de marcadores */
    @GetMapping
    public List<Marcador> obtenerTodos() {
        return repository.findAll();
    }

    /** POST /api/marcadores -> Persiste un nuevo marcador con nombre y coordenadas */
    @PostMapping
    public Marcador guardar(@RequestBody Marcador marcador) {
        return repository.save(marcador);
    }

    /** DELETE /api/marcadores/{id} -> Elimina marcador por ID con validación de existencia */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}