package com.example.proyecto.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Creadores")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Creadores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long creadoresId;

    @Column(name = "Nombre")
    @NotNull
    private String nombreCreador;

    @Column(name = "Apellido")
    @NotNull
    private String apellidoCreador;

    @Column(name = "Cargo")
    @NotNull
    private String cargoCreador;
}
