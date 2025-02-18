package com.mycompany.lab1poo.modelos;

abstract class Persona {
    private double id;
    private String nombre;
    private String apellido;
    private String email;

    public Persona(double id, String nombre, String apellido, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    @Override
    public String toString(){
        return id + "," + nombre + apellido + ", email: " + email;
    }


}
