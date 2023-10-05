package com.example.proyecto.Repositories;

import com.example.proyecto.Models.Servicios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiciosRepository extends JpaRepository<Servicios,Long> {
}
