package com.example.proyecto.Services;

import com.example.proyecto.Models.ClasificacionDeCentros;

import java.util.List;

public interface ClasificacionDeCentrosServices {
    List<ClasificacionDeCentros> listaDeClasificacion();

    ClasificacionDeCentros buscarClasificacionPorId(Long id);

    ClasificacionDeCentros guardarClasificacionDeCentros(ClasificacionDeCentros clasificacionDeCentrosNuevo);

    ClasificacionDeCentros editarClasificacionPorID (Long id,ClasificacionDeCentros clasificacionDeCentrosActualizado);

    void borrarCentros (Long id);

}
