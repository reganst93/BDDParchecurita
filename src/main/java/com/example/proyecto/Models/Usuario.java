package com.example.proyecto.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @NotNull
    @Size(min = 3, max = 25)
    private String usuarioNombre;

    @Column(name = "Apellido")
    @NotNull
    @Size(min = 3, max = 25)
    private String usuarioApellido;
    @Column(name = "Edad")
    @NotNull
    private Integer usuarioEdad;
    @Column(name = "Email")
    @NotNull
    @Email(message = "El correo electrónico no es válido")
    private String usuarioEmail;
    @NotNull
    @Size(min = 6, max = 10)
    @Column(name = "Nombre de usuario")
    private String nombreUsuario;

    @Column(name = "Password")
    @NotNull
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[-_.@#$%^&+=]).*$",
            message = "El password debe contener al menos una letra mayúscula, una letra minúscula, un dígito y un carácter especial")

    private String password;

    @OneToOne
    @JoinColumn(name = "token")
    private Token token;
}
