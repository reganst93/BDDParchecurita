package com.example.proyecto.Services;

import com.example.proyecto.Models.Usuario;
import com.example.proyecto.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceimpl implements UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listaDeUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarUsuarioPorId(Long id) {
        Boolean existe = usuarioRepository.existsById(id);
        if (existe) {
            Usuario usuarioEscogido = usuarioRepository.findById(id).get();
            return usuarioEscogido;
        } else {
            System.out.println("El id ingresado no es valido");
            return null;
        }
    }

    @Override
    public Usuario guardarUsuario(Usuario usuarioNuevo) {
        if (usuarioNuevo.getUsuarioEdad() < 18) {
            System.out.println("El Usuario debe ser mayor a 18 años");
            return null;
        } else if (usuarioRepository.findByUsuarioNombre(usuarioNuevo.getUsuarioNombre()) != null){
            System.out.println("El nombre de usuario ya esta en uso");
            return null;
        }else {
            return usuarioRepository.save(usuarioNuevo);
        }
    }

    @Override
    public Usuario editarUsuarioPorId(Long id, Usuario usuarioActualizado) {
        boolean existe = usuarioRepository.existsById(id);
        if (existe) {
            Usuario usuarioSeleccionado = usuarioRepository.findById(id).get();
            usuarioSeleccionado.setUsuarioNombre(usuarioActualizado.getUsuarioNombre());
            usuarioSeleccionado.setUsuarioApellido(usuarioActualizado.getUsuarioApellido());
            usuarioSeleccionado.setUsuarioEmail(usuarioActualizado.getUsuarioEmail());
            usuarioSeleccionado.setNombreUsuario(usuarioActualizado.getNombreUsuario());
            return usuarioRepository.save(usuarioActualizado);
        } else {
            System.out.println("El id entregado no es valido");
            return null;
        }


    }

    @Override
    public void borrarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
