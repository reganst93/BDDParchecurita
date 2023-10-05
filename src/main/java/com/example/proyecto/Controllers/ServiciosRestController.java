package com.example.proyecto.Controllers;

import com.example.proyecto.Models.Servicios;
import com.example.proyecto.Services.ServiciosServicesimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicios")
public class ServiciosRestController {
    @Autowired
    ServiciosServicesimpl serviciosServices;

    @GetMapping("lista")
    public List<Servicios> listaDeServicios(){
        List<Servicios> listaMostrar = serviciosServices.listaDeServicios();
        return listaMostrar;
    }

    @GetMapping("/{id}")
    public Servicios serviciosPorId (@PathVariable Long id){
        Servicios serviciosmostrar = serviciosServices.buscarServiciosPorId(id);
        return serviciosmostrar;
    }

    @PostMapping("/nuevo")
    public Servicios guardarNuevoServicio (@RequestBody Servicios servicioNuevo){
        Servicios serviciosParaGuardar = serviciosServices.guardarServicios(servicioNuevo);
        return serviciosParaGuardar;
    }

    @PutMapping("/editar/{id}")
    public Servicios editarServicioPorId (@PathVariable Long id, @RequestBody Servicios serviciosActualizados){
        Servicios servicioEditado = serviciosServices.editarServiciosPorId(id,serviciosActualizados);
        return servicioEditado;
    }

    @DeleteMapping("/borrar")
    public String borrarServiciosPorId (@PathVariable Long id){
        serviciosServices.borrarServicios(id);
        return "El tipo de servicio a sido borrado existosamente";
    }


}
