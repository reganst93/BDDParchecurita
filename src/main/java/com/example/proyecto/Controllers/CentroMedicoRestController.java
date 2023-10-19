package com.example.proyecto.Controllers;

import com.example.proyecto.DTO.CentroMDTO;
import com.example.proyecto.Models.CentrosMedicos;
import com.example.proyecto.Models.ClasificacionDeCentros;
import com.example.proyecto.Services.CentrosMedicosServicesimpl;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/centromedico")
public class CentroMedicoRestController {
    @Autowired
    CentrosMedicosServicesimpl centrosMedicosServices;

    @GetMapping("/lista")
    public ResponseEntity<List<CentroMDTO>> listaCentroMedicos(){
        List<CentrosMedicos> listaCentros = centrosMedicosServices.listaDeCentrosMedicos();
        List<CentroMDTO> listaMostrar = listaCentros.stream()
                .map(CentrosMedicos ->{
                    CentroMDTO centroMDTO = new CentroMDTO();
                    centroMDTO.setNombreDelCentro(CentrosMedicos.getNombreDelCentro());
                    centroMDTO.setComunaCentro(CentrosMedicos.getComunaCentro());
                    centroMDTO.setDireccionesCentros(CentrosMedicos.getDireccionesCentros());
                    centroMDTO.setHorarioAperturaSemana(CentrosMedicos.getHorarioAperturaSemana());
                    centroMDTO.setHorarioCierreSemana(CentrosMedicos.getHorarioCierreSemana());
                    centroMDTO.setHorarioAperturaSabado(CentrosMedicos.getHorarioAperturaSabado());
                    centroMDTO.setHorarioCierreSabado(CentrosMedicos.getHorarioCierreSabado());
                    centroMDTO.setHorarioAperturaDomingo(CentrosMedicos.getHorarioAperturaDomingo());
                    centroMDTO.setHorarioCierreDomingo(CentrosMedicos.getHorarioCierreDomingo());
                    centroMDTO.setTelefonoCentros(CentrosMedicos.getTelefonoCentros());
                    if (CentrosMedicos.getContactoOnline() != null){
                        centroMDTO.setDominioWeb(CentrosMedicos.getContactoOnline().getDominioWeb());
                        centroMDTO.setRedSocialId(CentrosMedicos.getContactoOnline().getRedSocialId());
                        centroMDTO.setContactoEmail(CentrosMedicos.getContactoOnline().getContactoEmail());
                    }
                    if (CentrosMedicos.getClasificacionDeCentros() != null){
                        centroMDTO.setClasificacionTipoCentro(CentrosMedicos.getClasificacionDeCentros().getClasificacionTipoCentro());
                    }
                    if (CentrosMedicos.getTriage() != null){
                        centroMDTO.setUrgencia(CentrosMedicos.getTriage().getUrgencia());

                    }
                    return centroMDTO;
                        })
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaMostrar);
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
    @DeleteMapping("/borrar/{id}")
    public String borrarCentroPorId (@PathVariable Long id){
        centrosMedicosServices.centrosMedicosborrar(id);
        return "El centro medico a sido borrado exitosamente";
    }



}
