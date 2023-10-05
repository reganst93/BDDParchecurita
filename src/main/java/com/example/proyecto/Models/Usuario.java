package com.example.proyecto.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long usuarioId;

    @Column(name = "Nombre")
    @NotNull
    @Size(min= 3, max = 25)
    private String usuarioNombre;

    @Column(name = "Apellido")
    @NotNull
    @Size(min = 3, max = 25)
    private String usuarioApellido;
    @Column(name= "Edad")
    @NotNull
    private Integer usuarioEdad;
    @Column(name= "Email")
    @NotNull
    @Email(message = "El correo electrónico no es válido")
    private String usuarioEmail;
    @NotNull
    @Size(min = 6, max = 10)
    @Column(name = "Nombre de usuario")
    private String nombreUsuario;

    @Column(name = "Password")
    @NotNull
    @Pattern(regexp ="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[-_.@#$%^&+=]).*$",
            message = "El password debe contener al menos una letra mayúscula, una letra minúscula, un dígito y un carácter especial")
    private String password;


    public Usuario() {
    }

    public Usuario(long usuarioId, String usuarioNombre, String usuarioApellido, Integer usuarioEdad, String usuarioEmail, String nombreUsuario, String password) {
        this.usuarioId = usuarioId;
        this.usuarioNombre = usuarioNombre;
        this.usuarioApellido = usuarioApellido;
        this.usuarioEdad = usuarioEdad;
        this.usuarioEmail = usuarioEmail;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
    }

    public long getUsuarioId() {
        return usuarioId;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public String getUsuarioApellido() {
        return usuarioApellido;
    }

    public void setUsuarioApellido(String usuarioApellido) {
        this.usuarioApellido = usuarioApellido;
    }

    public Integer getUsuarioEdad() {
        return usuarioEdad;
    }

    public void setUsuarioEdad(Integer usuarioEdad) {
        this.usuarioEdad = usuarioEdad;
    }

    public String getUsuarioEmail() {
        return usuarioEmail;
    }

    public void setUsuarioEmail(String usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
