package com.example.proyecto.Services;

import com.example.proyecto.Models.CentrosMedicos;
import com.example.proyecto.Repositories.CentrosMedicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CentrosMedicosServicesimpl implements CentrosMedicosServices {
    @Autowired
    CentrosMedicosRepository centrosMedicosRepository;


    @Override
    public List<CentrosMedicos> listaDeCentrosMedicos() {
        return centrosMedicosRepository.findAll();
    }

    @Override
    public CentrosMedicos buscarCentrosMedicosPorId(Long id) {
        Boolean existe = centrosMedicosRepository.existsById(id);
        if(existe){
            CentrosMedicos centrosMedicosEscogido =centrosMedicosRepository.findById(id).get();
            return centrosMedicosEscogido;
        }else {
            System.out.println("El id ingresado no es valido");
            return null;
        }
    }

    @Override
    public CentrosMedicos guardarCentrosMedico(CentrosMedicos centrosNuevo) {
        CentrosMedicos centrosMedicosExiste = centrosMedicosRepository.findByNombreDelCentro(centrosNuevo.getNombreDelCentro());
        if(centrosMedicosExiste != null){
            System.out.println("El nombre de centro medico ya existe");
            return null;
        }else {
            return centrosMedicosRepository.save(centrosNuevo);
        }
    }



    @Override
    public CentrosMedicos editarCentroMedicoPorID(Long id, CentrosMedicos centrosMedicosActualizado) {
        boolean existe = centrosMedicosRepository.existsById(id);
        if(existe){
            CentrosMedicos centrosMedicosSeleccionado = centrosMedicosRepository.findById(id).get();
            centrosMedicosSeleccionado.setNombreDelCentro(centrosMedicosActualizado.getNombreDelCentro());
            centrosMedicosSeleccionado.setComunaCentro(centrosMedicosActualizado.getComunaCentro());
            centrosMedicosSeleccionado.setDirecionesCentros(centrosMedicosActualizado.getDirecionesCentros());
            centrosMedicosSeleccionado.setHorarioAperturaSemana(centrosMedicosActualizado.getHorarioAperturaSemana());
            centrosMedicosSeleccionado.setHorarioCierreSemana(centrosMedicosActualizado.getHorarioCierreSemana());
            centrosMedicosSeleccionado.setHorarioAperturaFinDeSemana(centrosMedicosActualizado.getHorarioAperturaFinDeSemana());
            centrosMedicosSeleccionado.setHorarioAperturaFinDeSemana(centrosMedicosActualizado.getHorarioCierreFinDeSemana());
            return centrosMedicosRepository.save(centrosMedicosActualizado);
        }else{
            System.out.println("El id indicado no es valido");
            return null;
        }

    }

    @Override
    public void centrosMedicosborrar(Long id) {
    centrosMedicosRepository.deleteById(id);
    }
}
