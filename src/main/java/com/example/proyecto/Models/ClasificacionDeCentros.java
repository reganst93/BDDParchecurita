package com.example.proyecto.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Clasificación de centros")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClasificacionDeCentros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clasificacionDeCentrosId;

    @Column(name = "Tipo De Centro")
    @NotNull
    private String clasificacionTipoCentro;

    @ManyToMany(mappedBy = "TriageClasificacion")
    @JsonBackReference
    private List<Triage> triages;

    @OneToMany(mappedBy = "clasificacionDeCentros")
    @JsonBackReference
    private List<CentrosMedicos> centrosMedicos;




}
