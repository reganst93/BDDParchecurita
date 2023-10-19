package com.example.proyecto.Services;

import com.example.proyecto.DTO.UsuarioDTO;
import com.example.proyecto.Models.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> listaDeUsuarios();

    Usuario buscarUsuarioPorId (Long id);


    Usuario guardarUsuario(Usuario usuarioNuevo);

    UsuarioDTO registrarUsuario ( Usuario usuarioRegistrado);


    Usuario editarUsuarioPorId (Long id, Usuario usuarioActualizado);

    UsuarioDTO editarUsuarioPorEmail(String email, Usuario usuarioActualizadoe);

    void borrarUsuario (Long id);

}
