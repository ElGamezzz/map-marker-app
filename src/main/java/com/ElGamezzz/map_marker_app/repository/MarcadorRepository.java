package com.ElGamezzz.map_marker_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ElGamezzz.map_marker_app.model.Marcador;

@Repository
public interface MarcadorRepository extends JpaRepository<Marcador, Long> {
    // JpaRepository ya incluye findAll(), save(), deleteById(), etc.
}