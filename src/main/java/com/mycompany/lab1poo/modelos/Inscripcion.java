package com.mycompany.lab1poo.modelos;

public class Inscripcion {
    private Curso curso;
    private int año;
    private int semestre;
    private Estudiante estudiante;

    public Inscripcion (Curso curso, int año, int semestre, Estudiante estudiante){
        this.curso = curso;
        this.año = año;
        this.semestre = semestre;
        this.estudiante = estudiante;
    }

    public String toString(){
        return curso + ", " + año + ", " + semestre + ", " + estudiante;
    }

}
