package com.mycompany.lab1poo.modelos;

public class CursoProfesor {
    private int id;
    private Profesor profesor;
    private int año;
    private int semestre;
    private Curso curso;

    public CursoProfesor (int id, Profesor profesor, int año, int semestre, Curso curso){
        this.id = id;
        this.profesor = profesor;
        this.año = año;
        this.semestre = semestre;
        this.curso = curso;
    }

    public int getIdCursoProfesor() {
        return id;
    }

    public void setIdCursoProfesor(int id) {
        this.id = id;
    }

    public Profesor getProfesorCursoProfesor() {
        return profesor;
    }

    public void setProfesorCursoProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public int getAñoCursoProfesor() {
        return año;
    }

    public void setAñoCursoProfesor(int año) {
        this.año = año;
    }

    public int getSemestreCursoProfesor() {
        return semestre;
    }

    public void setSemestreCursoProfesor(int semestre) {
        this.semestre = semestre;
    }

    public Curso getCursoCursoProfesor() {
        return curso;
    }

    public void setCursoCursoProfesor(Curso curso) {
        this.curso = curso;
    }

    public String toString(){
        return "el id del curso: "+ id + "El profesor es: " + profesor + ", el año es: " + año + ", el semestre es: " + semestre + ", el curso es: " + curso;
    }
}
