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

    public String getCodigoEstudiante() {
        return codigo;
    }

    public void setCodigoEstudiante(String codigo) {
        this.codigo = codigo;
    }

    public Programa getProgramaEstudiante() {
        return programa;
    }

    public void setProgramaEstudiante(Programa programa) {
        this.programa = programa;
    }

    public boolean isActivoEstudiante() {
        return activo;
    }

    public void setActivoEstudiante(boolean activo) {
        this.activo = activo;
    }

    public double getPromedioEstudiante() {
        return promedio;
    }

    public void setPromedioEstudiante(double promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Estudiante: " + super.toString() + ", " + codigo + ", " + programa + ", " + activo + ", " + promedio;
    }

}
