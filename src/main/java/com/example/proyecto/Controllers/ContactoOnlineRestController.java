package com.example.proyecto.Controllers;

import com.example.proyecto.Models.ContactoOnline;
import com.example.proyecto.Services.ContactoOnlineServicesimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacto")
public class ContactoOnlineRestController {
    @Autowired
    ContactoOnlineServicesimpl contactoOnlineServices;

    @GetMapping("/lista")
    public List<ContactoOnline> listaContactoOnline(){
        List<ContactoOnline> listaMostrar = contactoOnlineServices.listaContactoOnline();
        return listaMostrar;
    }

    @GetMapping("/{id}")
    public ContactoOnline contactoOnlinePorId (@PathVariable Long id){
        ContactoOnline contactoOnlineMostrar = contactoOnlineServices.buscarContactoId(id);
        return contactoOnlineMostrar;
    }
    @PostMapping("/nuevo")
    public ContactoOnline contactoNuevo (@RequestBody ContactoOnline contactoOnlineNuevo){
        ContactoOnline contactoOnlineParaGuardar = contactoOnlineServices.guardarContacto(contactoOnlineNuevo);
        return contactoOnlineParaGuardar;
    }
    @PutMapping("/editar/{id}")
    public ContactoOnline editarContactoPorId (@PathVariable Long id, @RequestBody ContactoOnline contactoOnlineActualizado){
        ContactoOnline contactoOnlineEditado = contactoOnlineServices.editarContactoPorId(id, contactoOnlineActualizado);
        return contactoOnlineEditado;
    }

    @DeleteMapping("/borrar")
    public String borrarContactoPorId (@PathVariable long id){
        contactoOnlineServices.borrarContactoOnline(id);
        return "El centro medico a sido borrado exitosamente";
    }
}
