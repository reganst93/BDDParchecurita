package com.example.proyecto.Services;


import com.example.proyecto.Models.ContactoOnline;

import java.util.List;

public interface ContactoOnlineServices {
    List<ContactoOnline> listaContactoOnline();

    ContactoOnline buscarContactoId(Long id);


   ContactoOnline guardarContacto(ContactoOnline contactoOnlineNuevo);

    ContactoOnline editarContactoPorId (Long id, ContactoOnline contactoOnlineActualizado);

    void borrarContactoOnline (Long id);
}
