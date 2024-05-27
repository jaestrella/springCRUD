package com.examen.tickets.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.tickets.entidad.Matricula;
import com.examen.tickets.repositorio.MatriculaRepositorio;

@Service
public class MatriculaServicioImp implements MatriculaServicio {

    @Autowired
    private MatriculaRepositorio repositorio;

    @Override
    public List<Matricula> listarTodasLasMatriculas() {
        return repositorio.findAll();
    }

    @Override
    public Matricula guardarMatricula(Matricula matricula) {
        return repositorio.save(matricula);
    }

    @Override
    public Matricula obtenerMatriculaPorId(Long cod_matricula) {
        return repositorio.getReferenceById(cod_matricula);
    }

    @Override
    public Matricula actualizarMatricula(Matricula matricula) {
        return repositorio.save(matricula);
    }

    @Override
    public void eliminarMatricula(Long cod_matricula) {
        repositorio.deleteById(cod_matricula);
    }

}
