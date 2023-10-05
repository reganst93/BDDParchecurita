package com.example.proyecto.Services;

import com.example.proyecto.Models.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> listaDeUsuarios();

    Usuario buscarUsuarioPorId (Long id);


    Usuario guardarUsuario(Usuario usuarioNuevo);

    Usuario editarUsuarioPorId (Long id, Usuario usuarioActualizado);

    void borrarUsuario (Long id);

}
