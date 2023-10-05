package com.example.proyecto.Repositories;

import com.example.proyecto.Models.Triage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TriageRepository extends JpaRepository<Triage,Long> {

}
