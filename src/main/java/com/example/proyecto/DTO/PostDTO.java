package com.example.proyecto.DTO;

import com.example.proyecto.Models.Usuario;

import java.io.Serializable;
import java.util.Date;

public class PostDTO implements Serializable {
    private String postContenido;
    private Date fechaPost;
    private Usuario usuario;
}
