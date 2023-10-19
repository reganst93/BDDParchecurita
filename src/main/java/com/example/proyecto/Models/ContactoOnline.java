package com.example.proyecto.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

@Entity
@Table (name = "Contacto Online")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContactoOnline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long contactoOnlineId;

    @Column (name = "Página web")
    @URL (message = "La página web no es una URL válida")
    private String dominioWeb;

    @Column (name = "Red social")
    @URL (message = "La url de la red social no es válida")
    private String redSocialId;

    @Column(name= "Email")
    @Email(message = "El correo electrónico no es válido")
    private String contactoEmail;

    @OneToOne
    @JoinColumn(name = "Centro Médico")
    @JsonManagedReference
    private CentrosMedicos centrosMedicos;




}
