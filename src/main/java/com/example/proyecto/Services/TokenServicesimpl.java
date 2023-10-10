package com.example.proyecto.Services;

import com.example.proyecto.Models.Token;
import com.example.proyecto.Repositories.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TokenServicesimpl implements TokenServices {

    @Autowired
    TokenRepository tokenRepository;


    @Override
    public List<Token> listaDeToken() {
        return tokenRepository.findAll();
    }

    @Override
    public Token buscarTokenPorId(Long id) {
        Boolean existe = tokenRepository.existsById(id);
        if(existe){
            Token tokenEscogido = tokenRepository.findById(id).get();
            return tokenEscogido;
        }else {
            System.out.println("El id entregado no es valido");
            return null;
        }
    }

    @Override
    public Token guardarToken(Token tokenNuevo) {
        return tokenRepository.save(tokenNuevo);
    }

    @Override
    public Token editarTokenPorId(Long id, Token tokenActualizado) {
        Boolean existe = tokenRepository.existsById(id);
        if (existe){
            Token tokenSeleccionado= tokenRepository.findById(id).get();
            tokenSeleccionado.setTokenValue(tokenActualizado.getTokenValue());
            tokenActualizado.setExpirationTimeStamp(tokenActualizado.getExpirationTimeStamp());
            return tokenRepository.save(tokenActualizado);
        }else{
            System.out.println("El id entregado no es valido");
            return null;
        }
    }

    @Override
    public void borrarToken(long id) {
        tokenRepository.deleteById(id);
    }
}
