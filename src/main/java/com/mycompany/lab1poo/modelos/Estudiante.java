package com.mycompany.lab1poo.modelos;

public class Estudiante extends Persona {

    private String codigo;
    private Programa programa;
    private boolean activo;
    private double promedio;

    public Estudiante(double id, String nombre, String apellido, String email, String codigo, Programa programa, boolean activo, double promedio) {
        super(id, nombre, apellido, email);
        this.codigo = codigo;
        this.programa = programa;
        this.activo = activo;
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Estudiante: " + super.toString() + ", " + codigo + ", " + programa + ", " + activo + ", " + promedio;
    }

}
