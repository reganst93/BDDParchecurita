package com.example.proyecto.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioFormularioDTO implements Serializable {
    private String usuarioNombre;
    private String usuarioApellido;
    private String password;
}
