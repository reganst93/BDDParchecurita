package com.example.proyecto.Repositories;

import com.example.proyecto.Models.CentrosMedicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CentrosMedicosRepository extends JpaRepository<CentrosMedicos,Long> {
    CentrosMedicos findByNombreDelCentro(String nombreDelCentro);
}
