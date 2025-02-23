package com.mycompany.lab1poo.modelos;

public class Inscripcion {
    private int id;
    private Curso curso;
    private int año;
    private int semestre;
    private Estudiante estudiante;

    public Inscripcion (int id, Curso curso, int año, int semestre, Estudiante estudiante){
        this.id = id;
        this.curso = curso;
        this.año = año;
        this.semestre = semestre;
        this.estudiante = estudiante;
    }

    public int getIdInscripcion() {
        return id;
    }

    public void setIdInscripcion(int id) {
        this.id = id;
    }

    public Curso getCursoInscripcion() {
        return curso;
    }

    public void setCursoInscripcion(Curso curso) {
        this.curso = curso;
    }

    public int getAñoInscripcion() {
        return año;
    }

    public void setAñoInscripcion(int año) {
        this.año = año;
    }

    public int getSemestreInscripcion() {
        return semestre;
    }

    public void setSemestreInscripcion(int semestre) {
        this.semestre = semestre;
    }

    public Estudiante getEstudianteInscripcion() {
        return estudiante;
    }

    public void setEstudianteInscripcion(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public String toString(){
        return curso + ", " + año + ", " + semestre + ", " + estudiante;
    }

}
