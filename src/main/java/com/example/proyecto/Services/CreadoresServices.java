package com.example.proyecto.Services;



import com.example.proyecto.Models.Creadores;

import java.util.List;

public interface CreadoresServices {
    List<Creadores> listaCreadores();

    Creadores buscarCreadoresPorId(Long id);


    Creadores guardarCreador(Creadores creadorNuevo);

    Creadores editarCreadorPorId (Long id, Creadores creadoresActualizado);

    void borrarCreador (Long id);
}
