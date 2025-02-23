/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab1poo;

import com.mycompany.lab1poo.modelos.Curso;
import com.mycompany.lab1poo.modelos.Estudiante;
import com.mycompany.lab1poo.modelos.Facultad;
import com.mycompany.lab1poo.modelos.Inscripcion;
import com.mycompany.lab1poo.modelos.Profesor;
import com.mycompany.lab1poo.modelos.Programa;

/**
 *
 * @author Estudiante_MCA
 */
public class Lab1Poo {
 public static void main(String[] args) {
        // Creación de una facultad
        Facultad facultad = new Facultad(1, "Ingeniería", new Profesor(1001, "Carlos", "Perez", "cperez@uni.edu", "Tiempo Completo"));
        
        // Creación de un programa
        Programa programa = new Programa(101, "Ingeniería de Sistemas", 5, "R-2024", facultad);
        
        // Creación de un curso
        Curso curso = new Curso(5001, "Programación I", programa, true);
        
        // Creación de un profesor
        Profesor profesor = new Profesor(2001, "Ana", "Gomez", "agomez@uni.edu", "Catedrático");
        
        // Creación de un estudiante
        Estudiante estudiante = new Estudiante(3001, "Juan", "López", "jlopez@uni.edu", "E-2023001", programa, true, 4.2);
        
        // Creación de una inscripción
        Inscripcion inscripcion = new Inscripcion(curso, 2025, 1, estudiante);
        
        // Impresión de datos
        System.out.println("Facultad: " + facultad);
        System.out.println("Programa: " + programa);
        System.out.println("Curso: " + curso);
        System.out.println("Profesor: " + profesor);
        System.out.println("Estudiante: " + estudiante);
        System.out.println("Inscripción: " + inscripcion);
    }
}
