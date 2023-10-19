package com.example.proyecto.Controllers;

import com.example.proyecto.DTO.UsuarioDTO;
import com.example.proyecto.Models.Usuario;
import com.example.proyecto.Services.UsuarioServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/usuario")
public class UsuariorestController {
    @Autowired
    UsuarioServiceimpl usuarioService;

    @GetMapping("/lista")
    public ResponseEntity<List<UsuarioDTO>> listaDeUsuario(){
        List<Usuario> listaUsuarios = usuarioService.listaDeUsuarios();
        List<UsuarioDTO> listaMostrar = listaUsuarios.stream()
                .map(usuario -> {
                    UsuarioDTO usuarioDTO = new UsuarioDTO();
                    usuarioDTO.setNombreUsuario(usuario.getNombreUsuario());
                    usuarioDTO.setUsuarioEmail(usuario.getUsuarioEmail());
                    usuarioDTO.setUsuarioEdad(usuario.getUsuarioEdad());
                    return usuarioDTO;
                        })
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaMostrar);
    }
    @GetMapping("/{id}")
    public Usuario usuarioPorId (@PathVariable Long id){
        Usuario usuarioMostrar = usuarioService.buscarUsuarioPorId(id);
        return usuarioMostrar;
    }
   @PostMapping("/nuevo")
    public ResponseEntity<Usuario> guardarNuevoUsuario (@RequestBody Usuario usuarioNuevo){
       Usuario usuarioParaGuardar = usuarioService.guardarUsuario(usuarioNuevo);
       return new ResponseEntity<>(usuarioNuevo, HttpStatus.CREATED);
   }

    @PostMapping("/registro")
    public ResponseEntity<UsuarioDTO> registrarUsuario(@RequestBody Usuario usuarioNuevo) {
        UsuarioDTO usuarioGuardadoDTO = usuarioService.registrarUsuario(usuarioNuevo);

        if (usuarioGuardadoDTO != null) {
            return new ResponseEntity<>(usuarioGuardadoDTO, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


   @PostMapping("/login")
   @PutMapping("/editar/{id}")
   public Usuario editarUsuarioPorId (@PathVariable Long id, @RequestBody Usuario usuarioActualizado){
        Usuario usuarioEditado = usuarioService.editarUsuarioPorId(id,usuarioActualizado);
        return usuarioEditado;
   }
    @PutMapping("/ed/{email}")
    public UsuarioDTO editarUsuarioPorEmail(@PathVariable String email, @RequestBody Usuario usuarioActualizadoe) {
        UsuarioDTO usuarioEditado = usuarioService.editarUsuarioPorEmail(email,usuarioActualizadoe);
        return usuarioEditado;
    }

    @DeleteMapping("/borrar/{id}")
    public String borrarCursoPorId (@PathVariable Long id){
        usuarioService.borrarUsuario(id);
        return "El Usuario a sido borrado exitosamente";
   }
}
