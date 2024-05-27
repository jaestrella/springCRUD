package com.examen.tickets.entidad;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_matricula;

   
    private LocalDateTime fecha_matricula;

    @NotBlank(message = "Debe de introducir el dni")
    private String dni;

    @NotBlank(message = "Debe de introducir el nombre del alumno")
    private String nombre_alumno;

    @NotBlank(message = "Debe de introducir el telefono del alumno")
    private String telefono;


    public Long getCod_matricula() {
        return this.cod_matricula;
    }

    public void setCod_matricula(Long cod_matricula) {
        this.cod_matricula = cod_matricula;
    }

    public LocalDateTime getFecha_matricula() {
        return this.fecha_matricula;
    }

    public void setFecha_matricula(LocalDateTime fecha_matricula) {
        this.fecha_matricula = fecha_matricula;
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre_alumno() {
        return this.nombre_alumno;
    }

    public void setNombre_alumno(String nombre_alumno) {
        this.nombre_alumno = nombre_alumno;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
   
    @PrePersist
    public void asignarFecha(){
        fecha_matricula=LocalDateTime.now();
    }


    public Matricula(Long cod_matricula, LocalDateTime fecha_matricula, String dni, String nombre_alumno, String telefono) {
        this.cod_matricula = cod_matricula;
        this.fecha_matricula = fecha_matricula;
        this.dni = dni;
        this.nombre_alumno = nombre_alumno;
        this.telefono = telefono;
    }
    

    public Matricula(){
        super();
    }

}
