package com.examen.tickets.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.tickets.entidad.Matricula;

public interface MatriculaRepositorio extends JpaRepository<Matricula,Long>{
    
}
