package com.mycompany.lab1poo.modelos;

public class Curso {

    private int id;
    private String nombre; 
    private Programa programa; 
    private boolean activo;

    public Curso (int id, String nombre, Programa programa, boolean activo){
        this.id = id;
        this.nombre =  nombre;
        this.programa = programa;
        this.activo = activo;
    }

    public int getIdCurso() {
        return id;
    }

    public void setIdCurso(int id) {
        this.id = id;
    }

    public String getNombreCurso() {
        return nombre;
    }

    public void setNombreCurso(String nombre) {
        this.nombre = nombre;
    }

    public Programa getProgramaCurso() {
        return programa;
    }

    public void setProgramaCurso(Programa programa) {
        this.programa = programa;
    }

    public boolean isActivoCurso() {
        return activo;
    }

    public void setActivoCurso(boolean activo) {
        this.activo = activo;
    }

    public String toStringCurso(){
        return "La id es: " + id + ", el nombre e: " + nombre + ", el programa es: " +programa + ", el estado es: " + activo;
    }

}
