package com.example.proyecto.Repositories;

import com.example.proyecto.Models.ClasificacionDeCentros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasificacionDeCentrosRepository extends JpaRepository<ClasificacionDeCentros, Long> {
}
