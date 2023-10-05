package com.example.proyecto.Services;

import com.example.proyecto.Models.Servicios;

import java.util.List;

public interface ServiciosServices {

    List<Servicios> listaDeServicios();

    Servicios buscarServiciosPorId(Long id);

    Servicios guardarServicios (Servicios serviciosNuevos);

    Servicios editarServiciosPorId (Long id, Servicios serviciosActualizados);

    void borrarServicios (Long id);


}
