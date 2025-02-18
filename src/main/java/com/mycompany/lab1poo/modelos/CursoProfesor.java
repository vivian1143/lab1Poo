package com.mycompany.lab1poo.modelos;

public class CursoProfesor {
    private Profesor profesor;
    private int año;
    private int semestre;
    private Curso curso;

    public CursoProfesor (Profesor profesor, int año, int semestre, Curso curso){
        this.profesor = profesor;
        this.año = año;
        this.semestre = semestre;
        this.curso = curso;
    }

    public String toString(){
        return profesor + ", " + año + ", " + semestre + ", " + curso;
    }
}
