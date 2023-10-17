package com.example.proyecto.Services;

import com.example.proyecto.DTO.PostDTO;
import com.example.proyecto.Models.Post;
import com.example.proyecto.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServicesimpl implements PostServices {
    @Autowired
    PostRepository postRepository;

    @Override
    public List<Post> listaDePost() {
        return postRepository.findAll();
    }

    @Override
    public Post buscarPostPorId(Long id) {
        Boolean existe = postRepository.existsById(id);
        if(existe){
            Post postEscogido = postRepository.findById(id).get();
            return postEscogido;
        }else {
    } System.out.println("El id ingresado no es valido");
        return null;
    }

    @Override
    public Post guardarPost(Post postNuevo) {
        return postRepository.save(postNuevo);
    }


    @Override
    public Post editarPostPorId(Long id, Post postActualizado) {
        Boolean existe = postRepository.existsById(id);
        if (existe){
            Post postSeleccionado = postRepository.findById(id).get();
            postSeleccionado.setPostContenido(postActualizado.getPostContenido());
            postSeleccionado.setFechaPost(postActualizado.getFechaPost());
            return postRepository.save(postActualizado);
        }else{
            System.out.println("El id entregado no es valido");
            return null;
        }
    }

    @Override
    public void borrarPost(Long id) {
        postRepository.deleteById(id);

    }
}
