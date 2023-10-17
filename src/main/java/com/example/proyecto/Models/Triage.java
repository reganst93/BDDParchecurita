package com.example.proyecto.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Triage")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Triage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long triageId;

    @Column (name = "Categoria")
    @NotNull
    private String categoria;
    @Column (name = "Urgencia")
    @NotNull
    private String urgencia;

    @ManyToMany
    @JoinTable(
            name = "Triage_Clasificacion",
            joinColumns = @JoinColumn(name = "triage_id"),
            inverseJoinColumns = @JoinColumn(name = "clasificacion_id")
    )
    private List<ClasificacionDeCentros> TriageClasificacion;
}
