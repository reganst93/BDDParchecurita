package com.example.proyecto.Controllers;

import com.example.proyecto.Models.CentrosMedicos;
import com.example.proyecto.Services.CentrosMedicosServicesimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/centromedico")
public class CentroMedicoRestController {
    @Autowired
    CentrosMedicosServicesimpl centrosMedicosServices;

    @GetMapping("/lista")
    public List<CentrosMedicos> listaCentroMedicos(){
        List<CentrosMedicos> listaMostrar = centrosMedicosServices.listaDeCentrosMedicos();
        return listaMostrar;
    }
    @GetMapping("/{id}")
    public CentrosMedicos centrosMedicosPorId (@PathVariable Long id){
        CentrosMedicos centrosMedicosMostrar = centrosMedicosServices.buscarCentrosMedicosPorId(id);
        return centrosMedicosMostrar;
    }
    @PostMapping("/nuevo")
    public CentrosMedicos guardarNuevoCentro (@RequestBody CentrosMedicos centrosMedicosNuevo){
        CentrosMedicos centrosMedicosParaGuardar = centrosMedicosServices.guardarCentrosMedico(centrosMedicosNuevo);
        return centrosMedicosParaGuardar;
    }

    @PutMapping("/editar/{id}")
    public CentrosMedicos editarCentroPorID (@PathVariable Long id,@RequestBody CentrosMedicos centrosMedicoActualizado){
        CentrosMedicos centrosMedicoEditado = centrosMedicosServices.editarCentroMedicoPorID(id,centrosMedicoActualizado);
        return centrosMedicoEditado;
    }
    @DeleteMapping("/borrar")
    public String borrarCursoPorId (@PathVariable Long id){
        centrosMedicosServices.centrosMedicosborrar(id);
        return "El centro medico a sido borrado exitosamente";
    }



}
