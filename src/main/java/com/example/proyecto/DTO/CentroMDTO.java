package com.example.proyecto.DTO;

import com.example.proyecto.Models.ClasificacionDeCentros;
import com.example.proyecto.Models.ContactoOnline;
import com.example.proyecto.Models.Triage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Time;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CentroMDTO {
    private String nombreDelCentro;
    private String comunaCentro;
    private String direccionesCentros;
    private Time horarioAperturaSemana;
    private Time horarioCierreSemana;
    private Time horarioAperturaSabado;
    private Time horarioCierreSabado;
    private Time horarioAperturaDomingo;
    private Time horarioCierreDomingo;
    private Long telefonoCentros;
    private String imagenCentroMedico;
    private String dominioWeb;
    private String redSocialId;
    private String contactoEmail;
    private String clasificacionTipoCentro;
    private String urgencia;




}
