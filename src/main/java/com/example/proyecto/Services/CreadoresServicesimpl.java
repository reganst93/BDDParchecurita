package com.example.proyecto.Services;

import com.example.proyecto.Models.Creadores;
import com.example.proyecto.Repositories.CreadoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreadoresServicesimpl implements CreadoresServices {

    @Autowired
    CreadoresRepository creadoresRepository;


    @Override
    public List<Creadores> listaCreadores() {
        return creadoresRepository.findAll();
    }

    @Override
    public Creadores buscarCreadoresPorId(Long id) {
        Boolean existe = creadoresRepository.existsById(id);
        if(existe){
            Creadores creadorEscogido = creadoresRepository.findById(id).get();
            return creadorEscogido;
        } else {
            System.out.println("El id entregado no es valido");
            return null;
        }
    }

    @Override
    public Creadores guardarCreador(Creadores creadorNuevo) {
        return creadoresRepository.save(creadorNuevo);
    }

    @Override
    public Creadores editarCreadorPorId(Long id, Creadores creadoresActualizado) {
        Boolean existe = creadoresRepository.existsById(id);
        if (existe){
            Creadores creadorSeleccionado = creadoresRepository.findById(id).get();
            creadorSeleccionado.setNombreCreador(creadoresActualizado.getNombreCreador());
            creadorSeleccionado.setApellidoCreador(creadorSeleccionado.getApellidoCreador());
            creadorSeleccionado.setCargoCreador(creadorSeleccionado.getNombreCreador());
            return creadoresRepository.save(creadoresActualizado);
        }else {
            System.out.println("El id entregado no es valido");
            return null;
        }
    }


    @Override
    public void borrarCreador(Long id) {
        creadoresRepository.deleteById(id);
    }
}
