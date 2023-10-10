package com.example.proyecto.Controllers;

import com.example.proyecto.Models.Token;
import com.example.proyecto.Services.TokenServicesimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/token")
public class TokenRestController {
    @Autowired
    TokenServicesimpl tokenServices;

    @GetMapping("/lista")
    public List<Token> listaDeToken(){
        List<Token> listaMostrar = tokenServices.listaDeToken();
        return listaMostrar;
    }

    @GetMapping("/{id}")
    public Token tokenPorId (@PathVariable Long id){
        Token tokenMostrar = tokenServices.buscarTokenPorId(id);
        return tokenMostrar;
    }

    @PostMapping("/nuevo")
    public Token guardarToken (@RequestBody Token tokenNuevo){
        Token tokenParaGuardar = tokenServices.guardarToken(tokenNuevo);
        return tokenParaGuardar;
    }

    @PutMapping("/editar/{id}")
    public Token editarTokenPorId (@PathVariable Long id, @RequestBody Token tokenActualizado){
        Token tokenEditado = tokenServices.editarTokenPorId(id, tokenActualizado);
        return tokenEditado;
    }

    @DeleteMapping("/borrar")
    public String borrarTokenPorID (@PathVariable Long id){
        tokenServices.borrarToken(id);
        return "El token a sido borrado exitosamente";
    }
}
