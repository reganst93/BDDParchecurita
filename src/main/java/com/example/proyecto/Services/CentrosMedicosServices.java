package com.example.proyecto.Services;

import com.example.proyecto.Models.CentrosMedicos;
import com.example.proyecto.Models.Usuario;

import java.util.List;

public interface CentrosMedicosServices {
    List<CentrosMedicos> listaDeCentrosMedicos();

    CentrosMedicos buscarCentrosMedicosPorId (Long id);


    CentrosMedicos guardarCentrosMedico(CentrosMedicos centrosNuevo);

    CentrosMedicos editarCentroMedicoPorID (Long id, CentrosMedicos centrosMedicosActualizados);

    void centrosMedicosborrar (Long id);

}
