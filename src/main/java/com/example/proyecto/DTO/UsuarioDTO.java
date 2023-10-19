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
public class UsuarioDTO implements Serializable {
private String nombreUsuario;
private String usuarioEmail;
private Integer usuarioEdad;

}
