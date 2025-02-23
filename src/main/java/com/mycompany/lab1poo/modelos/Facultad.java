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

    public double getIdFacultad() {
        return id;
    }

    public void setIdFacultad(double id) {
        this.id = id;
    }

    public String getNombreFacultad() {
        return nombre;
    }

    public void setNombreFacultad(String nombre) {
        this.nombre = nombre;
    }

    public Persona getDecanoFacultad() {
        return decano;
    }

    public void setDecanoFacultad(Persona decano) {
        this.decano = decano;
    }

    @Override
    public String toString(){
        return "El id es: " + id + "\n" + "El nombre de la facultad es:  " + nombre + "\n" +" el decano es: " + decano;
    }
}
