package com.example.proyecto.Models;

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
import java.util.List;

@Entity
@Table(name = "Centros MEdicos")
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

    @Column(name = "Direccion")
    @NotNull
    private String direcionesCentros;

    @Column(name = "Apertura")
    @NotNull
    @JsonFormat(pattern = "HH:mm:ss")
    private Time horarioAperturaSemana;

    @Column(name = "Cierre")
    @NotNull
    @JsonFormat(pattern = "HH:mm:ss")
    private Time horarioCierreSemana;

    @Column(name = "Apertura sabado/domingo")
    @NotNull
    @JsonFormat(pattern = "HH:mm:ss")
    private Time horarioAperturaFinDeSemana;

    @Column(name = "CierreAp sabado/domingo")
    @NotNull
    @JsonFormat(pattern = "HH:mm:ss")
    private Time horarioCierreFinDeSemana;

    @Column(name = "Telefonos")
    @Min(900000000)
    @Max(999999999)
    private Integer telefonoCentros;

    @OneToOne(mappedBy = "centrosMedicos")
    private ContactoOnline contactoOnline;

}