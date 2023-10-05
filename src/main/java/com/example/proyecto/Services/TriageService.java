package com.example.proyecto.Services;

import com.example.proyecto.Models.Triage;

import java.util.List;

public interface TriageService {
    List<Triage> listatriage();

    Triage buscarTriagePorId(Long id);


    Triage guardarTriage(Triage triageNuevo);

    Triage editarTriagePorId (Long id, Triage triageActualizado);

    void borrarTriage (Long id);
}