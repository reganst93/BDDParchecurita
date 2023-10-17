package com.example.proyecto.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "Post")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column(name = "Contenido")
    @Size(min = 4, max = 300)
    private String postContenido;

    @Column(name = "Fecha")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaPost;

    @ManyToOne
    @JoinColumn(name = "usuarioId") // Cambia "usuario" al nombre de la columna de la clave foránea en la tabla "Post".
    private Usuario usuario;








}