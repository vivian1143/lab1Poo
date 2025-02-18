package com.mycompany.lab1poo.modelos;

public class Profesor extends Persona {
    private String tipoContrato;
    
    public Profesor(double id, String nombre, String apellido, String email, String tipoContrato){
        super(id, nombre, apellido, email);
        this.tipoContrato = tipoContrato;
    } 
    @Override
    public String toString() {
        return "Profesor: " + super.toString() + ", " + tipoContrato;
    }
}
