package com.example.proyecto.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.Date;

@Entity
@Table(name = "Token")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tokenId;

    @Column(name = "token_value")
    @NotNull
    @UniqueElements
    private String tokenValue;

    @Column(name = "expiration_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationTimeStamp;

    @OneToOne(mappedBy = "token")
    private Usuario usuario;

}
