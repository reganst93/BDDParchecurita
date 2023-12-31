package com.example.proyecto.Controllers;

import com.example.proyecto.Models.ClasificacionDeCentros;
import com.example.proyecto.Services.ClasificacionDeCentrosServicesimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/cdcentros")
public class ClasificacionDeCentrosRestController {

    @Autowired
    ClasificacionDeCentrosServicesimpl clasificacionDeCentrosServices;

    @GetMapping("/lista")
    public List<ClasificacionDeCentros> listaDeClasificacion(){
        List<ClasificacionDeCentros> listaMostrar = clasificacionDeCentrosServices.listaDeClasificacion();
        return listaMostrar;
    }
    @GetMapping("/{id}")
    public ClasificacionDeCentros clasificacionDeCentrosPorId (@PathVariable Long id){
        ClasificacionDeCentros clasificacionDeCentrosMostrar = clasificacionDeCentrosServices.buscarClasificacionPorId(id);
        return clasificacionDeCentrosMostrar;
    }

    @PostMapping("/nuevo")
    public ClasificacionDeCentros guardarNuevaClasificacion (@RequestBody ClasificacionDeCentros clasificacionDeCentrosNuevo){
        ClasificacionDeCentros clasificacionParaGuardar = clasificacionDeCentrosServices.guardarClasificacionDeCentros(clasificacionDeCentrosNuevo);
        return clasificacionParaGuardar;
    }

    @PutMapping("/editar/{id}")
    public ClasificacionDeCentros editarCentros (@PathVariable Long id, @RequestBody ClasificacionDeCentros clasificacionDeCentrosActualizado){
        ClasificacionDeCentros clasificacionDeCentrosEditado = clasificacionDeCentrosServices.editarClasificacionPorID(id,clasificacionDeCentrosActualizado);
        return clasificacionDeCentrosEditado;
    }
    @DeleteMapping("/borrar/{id}")
    public String borrarCentrosPorId (@PathVariable Long id){
        clasificacionDeCentrosServices.clasificacionBorrar(id);
        return "La Clasificacion a sido borrada exitosamente";
    }
}

