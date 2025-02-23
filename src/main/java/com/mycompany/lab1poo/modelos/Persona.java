package com.mycompany.lab1poo.modelos;

public class Persona {
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

    public double getIdPersona() {
        return id;
    }

    public void setIdPersona(double id) {
        this.id = id;
    }

    public String getNombrePersona() {
        return nombre;
    }

    public void setNombrePersona(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPersona() {
        return apellido;
    }

    public void setApellidoPersona(String apellido) {
        this.apellido = apellido;
    }

    public String getEmailPersona() {
        return email;
    }

    public void setEmailPersona(String email) {
        this.email = email;
    }

    @Override
    public String toString(){
        return id + ", " + nombre + apellido + ", email: " + email;
    }


}
