package com.example.proyecto.Controllers;

import com.example.proyecto.Models.Triage;
import com.example.proyecto.Services.TriageServicesimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/triage")
public class TriageRestControllers {
    @Autowired
    TriageServicesimpl triageservices;

    @GetMapping("/lista")
    public List<Triage> listaDeTriage(){
        List<Triage> listaMostrar = triageservices.listatriage();
        return listaMostrar;
    }
    @GetMapping("/{id}")
    public Triage triagePorId (@PathVariable Long id){
        Triage triageMostrar = triageservices.buscarTriagePorId(id);
        return triageMostrar;
    }
    @PostMapping("/nuevo")
    public Triage guardarNuevoTriage (@RequestBody Triage triageNuevo){
        Triage triageParaGuardar = triageservices.guardarTriage(triageNuevo);
        return triageParaGuardar;
    }
    @PutMapping("/editar/{id}")
    public Triage editarTriagePorId (@PathVariable Long id, @RequestBody Triage triageActualizado){
        Triage triageEditado = triageservices.editarTriagePorId(id,triageActualizado);
        return triageEditado;
    }
    @DeleteMapping("/borrar")
    public String borrarTriagePorId (@PathVariable Long id){
        triageservices.borrarTriage(id);
        return "El triage a sido borrado exitosamente";
    }
}
