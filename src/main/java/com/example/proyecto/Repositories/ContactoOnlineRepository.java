package com.example.proyecto.Repositories;

import com.example.proyecto.Models.ContactoOnline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoOnlineRepository extends JpaRepository<ContactoOnline, Long> {
}
