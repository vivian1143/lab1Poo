package com.mycompany.lab1poo.servicios;

import modelo.Curso;
import modelo.Estudiante;
import modelo.Profesor;

public interface IServicios {

    void inscribirCursoProfesor(Profesor profesor, Curso curso);
    void inscribirEstudianteEnCurso(Estudiante estudiante, Curso curso, String semestre);

    boolean eliminarInscripcion(int idInscripcion);
    boolean actualizarInscripcion(int idInscripcion, String nuevoSemestre);

    // Métodos de persistencia
    void guardarDatos();
    void cargarDatos();
}
