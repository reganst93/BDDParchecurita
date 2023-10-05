package com.example.proyecto.Controllers;

import com.example.proyecto.Models.Usuario;
import com.example.proyecto.Services.UsuarioServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuariorestController {
    @Autowired
    UsuarioServiceimpl usuarioService;

    @GetMapping("/lista")
    public List<Usuario> listaDeUsuarios(){
        List<Usuario> listaMostrar = usuarioService.listaDeUsuarios();
    return listaMostrar;
    }
    @GetMapping("/{id}")
    public Usuario usuarioPorId (@PathVariable Long id){
        Usuario usuarioMostrar = usuarioService.buscarUsuarioPorId(id);
        return usuarioMostrar;
    }
   @PostMapping("/nuevo")
    public Usuario guardarNuevoUsuario (@RequestBody Usuario usuarioNuevo){
       Usuario usuarioParaGuardar = usuarioService.guardarUsuario(usuarioNuevo);
       return usuarioParaGuardar;
   }

   @PutMapping("/editar/{id}")
   public Usuario editarUsuarioPorId (@PathVariable Long id, @RequestBody Usuario usuarioActualizado){
        Usuario usuarioEditado = usuarioService.editarUsuarioPorId(id,usuarioActualizado);
        return usuarioEditado;
   }
   @DeleteMapping("/borrar")
    public String borrarCursoPorId (@PathVariable Long id){
        usuarioService.borrarUsuario(id);
        return "El Usuario a sido borrado exitosamente";
   }
}
