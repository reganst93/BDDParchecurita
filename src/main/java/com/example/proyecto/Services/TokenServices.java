package com.example.proyecto.Services;

import com.example.proyecto.Models.Token;

import java.util.List;

public interface TokenServices {
    List<Token> listaDeToken();

    Token buscarTokenPorId(Long id);

    Token guardarToken (Token tokenNuevo);

    Token editarTokenPorId (Long id, Token tokenActualizado);

    void borrarToken (long id);
}
