package com.example.proyecto.Repositories;

import com.example.proyecto.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Usuario findByUsuarioNombre(String usuarioNombre);
    Usuario findByUsuarioEmail(String usuarioEmail);

}
