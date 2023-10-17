package com.example.proyecto.Services;

import com.example.proyecto.Models.ClasificacionDeCentros;
import com.example.proyecto.Repositories.ClasificacionDeCentrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClasificacionDeCentrosServicesimpl implements ClasificacionDeCentrosServices{
    @Autowired
    ClasificacionDeCentrosRepository clasificacionDeCentrosRepository;

    @Override
    public List<ClasificacionDeCentros> listaDeClasificacion() {

        return clasificacionDeCentrosRepository.findAll();
    }
    @Override
    public ClasificacionDeCentros buscarClasificacionPorId(Long id) {

        boolean existe = clasificacionDeCentrosRepository.existsById(id);
        if(existe){
            ClasificacionDeCentros clasificacionDeCentrosEscogido = clasificacionDeCentrosRepository.findById(id).get();
            return clasificacionDeCentrosEscogido;
        } else {
            System.out.println("El id entregado no es valido");
            return null;
        }
    }

    @Override
    public ClasificacionDeCentros guardarClasificacionDeCentros(ClasificacionDeCentros clasificacionDeCentrosNuevo) {
       return clasificacionDeCentrosRepository.save(clasificacionDeCentrosNuevo);
    }

    @Override
    public ClasificacionDeCentros editarClasificacionPorID(Long id, ClasificacionDeCentros clasificacionDeCentrosActualizado) {
        Boolean existe = clasificacionDeCentrosRepository.existsById(id);
        if(existe){
            ClasificacionDeCentros clasificacionDeCentrosSeleccionado = clasificacionDeCentrosRepository.findById(id).get();
            clasificacionDeCentrosSeleccionado.setClasificacionTipoCentro(clasificacionDeCentrosActualizado.getClasificacionTipoCentro());
            return clasificacionDeCentrosRepository.save(clasificacionDeCentrosActualizado);
        }else {
            System.out.println("El id entregado no es valido");
            return null;
        }
    }

    @Override
    public void clasificacionBorrar (Long id){
        clasificacionDeCentrosRepository.deleteById(id);
    }
}
