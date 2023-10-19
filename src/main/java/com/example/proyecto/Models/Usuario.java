package com.example.proyecto.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Usuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long usuarioId;

    @Column(name = "Nombre")

    @Size(min = 3, max = 25)
    private String usuarioNombre;

    @Column(name = "Apellido")

    @Size(min = 3, max = 25)
    private String usuarioApellido;
    @Column(name = "Edad")
    @NotNull
    private Integer usuarioEdad;
    @Column(name = "Email")
    @NotNull
    @Email(message = "El correo electrónico no es válido")
    private String usuarioEmail;

    @Size(min = 6, max = 10)
    @Column(name = "Nombre de usuario")
    private String nombreUsuario;

    @Column(name = "Password")

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[-_.@#$%^&+=]).*$",
            message = "El password debe contener al menos una letra mayúscula, una letra minúscula, un dígito y un carácter especial")

    private String password;



    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Post> usuarioPost;

}
