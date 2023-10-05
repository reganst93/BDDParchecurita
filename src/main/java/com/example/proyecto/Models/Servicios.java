package com.example.proyecto.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Tipos de servicios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Servicios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long serviciosId;

    @Column (name = "Categorías de servicio")
    @NotNull
    private String categoriaServicio;




}
