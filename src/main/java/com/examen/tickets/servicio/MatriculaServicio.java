package com.examen.tickets.servicio;

import java.util.List;

import com.examen.tickets.entidad.Matricula;

public interface MatriculaServicio {

    public List<Matricula> listarTodasLasMatriculas();
    
    public Matricula guardarMatricula(Matricula matricula);

    public Matricula obtenerMatriculaPorId(Long cod_matricula);

    public Matricula actualizarMatricula(Matricula matricula);

    public void eliminarMatricula(Long cod_matricula);
}
