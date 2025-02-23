package com.mycompany.lab1poo.modelos;

public class Programa {

    private double id;
    private String nombre;
    private double duracion;
    private String registro; 
    private Facultad facultad;

    public  Programa (double id, String nombre, double duracion, String registro, Facultad facultad){
        this.id= id;
        this.nombre= nombre;
        this.duracion = duracion;
        this.registro = registro;
        this.facultad = facultad;
    }

    public double getIdPrograma() {
        return id;
    }

    public void setIdPrograma(double id) {
        this.id = id;
    }

    public String getNombrePrograma() {
        return nombre;
    }

    public void setNombrePrograma(String nombre) {
        this.nombre = nombre;
    }

    public double getDuracionPrograma() {
        return duracion;
    }

    public void setDuracionPrograma(double duracion) {
        this.duracion = duracion;
    }

    public String getRegistroPrograma() {
        return registro;
    }

    public void setRegistroPrograma(String registro) {
        this.registro = registro;
    }

    public Facultad getFacultadPrograma() {
        return facultad;
    }

    public void setFacultadPrograma(Facultad facultad) {
        this.facultad = facultad;
    }

    @Override
    public String toString(){
        return id + ", " + nombre + ", " + duracion + ", " + registro + ", " + facultad;
    }

}
