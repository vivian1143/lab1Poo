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

    public String toString(){
        return id + ", " + nombre + ", " +programa + ", " + activo;
    }

}
