package com.example.proyecto.Services;

import com.example.proyecto.Models.Triage;
import com.example.proyecto.Repositories.TriageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TriageServicesimpl implements TriageService{

    @Autowired
    TriageRepository triageRepository;

    @Override
    public List<Triage> listatriage() {
        return triageRepository.findAll();
    }

    @Override
    public Triage buscarTriagePorId(Long id) {
        Boolean existe = triageRepository.existsById(id);
        if (existe){
            Triage triageescogido = triageRepository.findById(id).get();
            return triageescogido;

        }else {
            System.out.println("El id entregado no es valido");
            return null;
        }
    }

    @Override
    public Triage guardarTriage(Triage triageNuevo) {
        if (triageNuevo.getTriageId() > 6 ){
            System.out.println("No pueden ser mas de 5 categorias");
            return null;
        } else {
            return triageRepository.save(triageNuevo);
        }
    }
    @Override
    public Triage editarTriagePorId(Long id, Triage triageActualizado){
        boolean existe = triageRepository.existsById(id);
        if(existe){
            Triage triageSeleccionado = triageRepository.findById(id).get();
            triageSeleccionado.setCategoria(triageActualizado.getCategoria());
            triageSeleccionado.setUrgencia(triageActualizado.getUrgencia());
            return triageRepository.save(triageActualizado);
        }else {
            System.out.println("El id entregado no es valido");
            return null;
        }
    }
    @Override
    public void borrarTriage (Long id){
        triageRepository.deleteById(id);
    }
}
