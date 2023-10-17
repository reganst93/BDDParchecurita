package com.example.proyecto.Services;

import com.example.proyecto.DTO.PostDTO;
import com.example.proyecto.Models.Post;

import java.util.List;

public interface PostServices {
List<Post> listaDePost();

Post buscarPostPorId(Long id);

Post guardarPost(Post postNuevo);

Post editarPostPorId(Long id, Post postActualizado);

void borrarPost (Long id);




}
