package com.example.proyecto.Services;

import com.example.proyecto.Models.Servicios;
import com.example.proyecto.Repositories.ServiciosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciosServicesimpl implements ServiciosServices {

    @Autowired
    ServiciosRepository serviciosRepository;

    @Override
    public List<Servicios> listaDeServicios() {
        return serviciosRepository.findAll();
    }

    @Override
    public Servicios buscarServiciosPorId(Long id) {
        boolean existe = serviciosRepository.existsById(id);
        if (existe) {
            Servicios serviciosEscogidos = serviciosRepository.findById(id).get();
            return serviciosEscogidos;
        }else {
            System.out.println("El id entregado no es valido");
            return null;
        }
    }

    @Override
    public Servicios guardarServicios(Servicios serviciosNuevos) {
        return serviciosRepository.save(serviciosNuevos);
    }

    @Override
    public Servicios editarServiciosPorId(Long id, Servicios serviciosActualizados) {
        Boolean existe = serviciosRepository.existsById(id);
        if(existe){
            Servicios servicioSeleccionado = serviciosRepository.findById(id).get();
            servicioSeleccionado.setCategoriaServicio(serviciosActualizados.getCategoriaServicio());
            return serviciosRepository.save(serviciosActualizados);
        }else{
            System.out.println("El id entregado no es valido");
            return null;
        }
    }

    @Override
    public void borrarServicios(Long id) {
        serviciosRepository.deleteById(id);

    }
}
