package com.example.proyecto.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "Centros Médicos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CentrosMedicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long centroMedicoID;

    @Column(name = "Nombre")
    @NotNull
    private String nombreDelCentro;

    @Column(name = "Comunas")
    @NotNull
    private String comunaCentro;

    @Column(name = "Dirección")
    @NotNull
    private String direccionesCentros;

    @Column(name = "Apertura")
    @NotNull
    @JsonFormat(pattern = "HH:mm:ss")
    private Time horarioAperturaSemana;

    @Column(name = "Cierre")
    @NotNull
    @JsonFormat(pattern = "HH:mm:ss")
    private Time horarioCierreSemana;

    @Column(name = "Apertura sábado")
    @JsonFormat(pattern = "HH:mm:ss")
    private Time horarioAperturaSabado;

    @Column(name = "Cierre sábado")
    @JsonFormat(pattern = "HH:mm:ss")
    private Time horarioCierreSabado;

    @Column(name = "Apertura domingo")
    @JsonFormat(pattern = "HH:mm:ss")
    private Time horarioAperturaDomingo;

    @Column(name = "Cierre domingo")
    @JsonFormat(pattern = "HH:mm:ss")
    private Time horarioCierreDomingo;

    @Column(name = "Teléfonos")
    @Min(000000000)
    @Max(999999999)
    private Long telefonoCentros;

    @Column(name = "imagen")
    private String imagenCentroMedico;

    @OneToOne(mappedBy = "centrosMedicos")
    @JsonBackReference
    @JsonIgnore
    private ContactoOnline contactoOnline;

    @ManyToOne
    @JoinColumn(name = "Clasificación de centro")
    private ClasificacionDeCentros clasificacionDeCentros;

    @ManyToOne
    @JoinColumn(name = "Tipos de Triage")
    private Triage triage;

}