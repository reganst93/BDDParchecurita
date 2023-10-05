package com.example.proyecto.Repositories;

import com.example.proyecto.Models.Creadores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreadoresRepository extends JpaRepository<Creadores,Long> {
}
