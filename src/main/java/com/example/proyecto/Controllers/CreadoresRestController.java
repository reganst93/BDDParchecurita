package com.example.proyecto.Controllers;

import com.example.proyecto.Models.Creadores;
import com.example.proyecto.Services.CreadoresServicesimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/creadores")
public class CreadoresRestController {
    @Autowired
    CreadoresServicesimpl creadoresServices;

    @GetMapping("/lista")
    public List<Creadores> listacreadores(){
        List<Creadores> listaMostrar = creadoresServices.listaCreadores();
        return listaMostrar;
    }

    @GetMapping("/{id}")
    public Creadores creadoresPorId (@PathVariable Long id){
        Creadores creadoresMostrar = creadoresServices.buscarCreadoresPorId(id);
        return creadoresMostrar;
    }

    @PostMapping("/nuevo")
    public Creadores guardarNuevoCreador (@RequestBody Creadores creadorNuevo){
    Creadores creadorParaGuardar = creadoresServices.guardarCreador(creadorNuevo);
    return creadorParaGuardar;
    }

    @PutMapping("/editar/{id}")
    public Creadores editarCreadorPorId (@PathVariable Long id, @RequestBody Creadores creadorActualizado){
        Creadores creadorEditado = creadoresServices.editarCreadorPorId(id, creadorActualizado);
        return creadorEditado;
    }
    @DeleteMapping("/borrar/{id}")
    public String borrarCreadorPorId (@PathVariable Long id){
        creadoresServices.borrarCreador(id);
        return "El creador a sido borrado existosamente";
    }
}

