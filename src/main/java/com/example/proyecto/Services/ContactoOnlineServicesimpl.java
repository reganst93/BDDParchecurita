package com.example.proyecto.Services;

import com.example.proyecto.Models.ContactoOnline;
import com.example.proyecto.Repositories.ContactoOnlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactoOnlineServicesimpl implements ContactoOnlineServices {

    @Autowired
    ContactoOnlineRepository contactoOnlineRepository;

    @Override
    public List<ContactoOnline> listaContactoOnline() {
        return contactoOnlineRepository.findAll();
    }

    @Override
    public ContactoOnline buscarContactoId(Long id) {
       Boolean existe = contactoOnlineRepository.existsById(id);
        if (existe) {
            ContactoOnline contactoOnlineEscogido = contactoOnlineRepository.findById(id).get();
            return contactoOnlineEscogido;
        }else{
            System.out.println("El id entregado no es valido");
            return null;
        }
    }

    @Override
    public ContactoOnline guardarContacto(ContactoOnline contactoOnlineNuevo) {
        return contactoOnlineRepository.save(contactoOnlineNuevo);
    }

    @Override
    public ContactoOnline editarContactoPorId(Long id, ContactoOnline contactoOnlineActualizado) {
        Boolean existe = contactoOnlineRepository.existsById(id);
        if(existe){
            ContactoOnline contactoOnlineSeleccionado = contactoOnlineRepository.findById(id).get();
            contactoOnlineSeleccionado.setDominioWeb(contactoOnlineActualizado.getDominioWeb());
            contactoOnlineSeleccionado.setRedSocialId(contactoOnlineActualizado.getRedSocialId());
            contactoOnlineSeleccionado.setUsuarioEmail(contactoOnlineActualizado.getUsuarioEmail());
            return contactoOnlineRepository.save(contactoOnlineActualizado);
        }else {
            System.out.println("El id entregado no es valido");
            return null;
        }
    }

    @Override
    public void borrarContactoOnline(Long id) {
        contactoOnlineRepository.deleteById(id);
    }
}
