package com.mycompany.lab1poo.modelos;

public class Facultad {
    private double id; 
    private String nombre;
    private Persona decano;

    public Facultad (double id, String nombre, Persona decano){
        this.id = id;
        this.nombre = nombre;
        this.decano = decano;
    }

    @Override
    public String toString(){
        return id + " " + nombre + " el decano es: " + decano;
    }
}
