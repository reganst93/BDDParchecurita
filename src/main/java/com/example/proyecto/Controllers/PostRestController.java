package com.example.proyecto.Controllers;

import com.example.proyecto.Models.Post;
import com.example.proyecto.Services.PostServicesimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/post")
public class PostRestController {
    @Autowired
    PostServicesimpl postServices;

    @GetMapping("/lista")
    public List<Post> listaPost(){
        List<Post> listaMostrar = postServices.listaDePost();
        return listaMostrar;
    }

    @GetMapping("/{id}")
    public Post postPorId (@PathVariable Long id){
        Post postMostrar = postServices.buscarPostPorId(id);
        return postMostrar;
    }

    @PostMapping("/nuevo")
    public Post guardarNuevoPost (@RequestBody Post postNuevo){
        Post postParaGuardar = postServices.guardarPost(postNuevo);
        return postParaGuardar;
    }

    @PutMapping("/editar/{id}")
    public Post editarPostPorId (@PathVariable Long id,@RequestBody Post postActualizado){
        Post postEditado = postServices.editarPostPorId(id,postActualizado);
        return postEditado;
    }
    //@GetMapping("/email")
    //public Post postPorEmail (@PathVariable String e)

    @DeleteMapping("/eliminar/{id}")
    public String borrarPost (@PathVariable Long id){
        postServices.borrarPost(id);
        return "El Post a sido borrado exitosamente";
    }
}


