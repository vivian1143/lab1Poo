package com.mycompany.lab1poo;

import com.mycompany.lab1poo.modelos.*;
import com.mycompany.lab1poo.servicios.*;

import java.util.Scanner;

public class Lab1Poo {
       public static void main(String[] args) {
              // Creación de los servicios
              CursosInscritos cursosInscritos = new CursosInscritos();
              CursosProfesores cursosProfesores = new CursosProfesores();
              InscripcionesPersonas inscripcionesPersonas = new InscripcionesPersonas();

              // Llenado inicial de los datos, agregados directamente desde el código
              agregarDatosIniciales(cursosInscritos, cursosProfesores, inscripcionesPersonas);

              // Menú de la aplicación
              Scanner scanner = new Scanner(System.in);
              int opcion;

              do {
                     System.out.println("===== Menú Principal =====");
                     System.out.println("1. Leer información de inscripciones de cursos");
                     System.out.println("2. Leer información de asignación de profesores");
                     System.out.println("3. Leer información de inscripciones de personas");
                     System.out.println("4. Salir");
                     System.out.print("Seleccione una opción: ");
                     opcion = scanner.nextInt();

                     switch (opcion) {
                            case 1:
                                   System.out.println("\n=== Inscripciones de Cursos ===");
                                   cursosInscritos.cargarDatos(); // Carga desde el archivo
                                   System.out.println(cursosInscritos.imprimirListado());
                                   break;

                            case 2:
                                   System.out.println("\n=== Cursos y Profesores ===");
                                   cursosProfesores.cargarDatos(); // Carga desde el archivo
                                   System.out.println(cursosProfesores.imprimirListado());
                                   break;

                            case 3:
                                   System.out.println("\n=== Inscripciones de Personas ===");
                                   inscripcionesPersonas.cargarDatos(); // Carga desde el archivo
                                   System.out.println(inscripcionesPersonas.imprimirListado());
                                   break;

                            case 4:
                                   System.out.println("¡Saliendo del programa!");
                                   break;

                            default:
                                   System.out.println("Opción inválida, intente de nuevo.");
                     }

              } while (opcion != 4);

              scanner.close();
       }

       private static void agregarDatosIniciales(CursosInscritos cursosInscritos, CursosProfesores cursosProfesores, InscripcionesPersonas inscripcionesPersonas) {
              // === Agregar programas ===
              Programa programa1 = new Programa(1, "Ingeniería de Sistemas", 5.0, "IS-001", null);
              Programa programa2 = new Programa(2, "Administración", 4.0, "ADM-002", null);

              // === Agregar estudiantes ===
              Estudiante estudiante1 = new Estudiante(1, "Juan", "Pérez", "juan.perez@email.com", "ES001", programa1, true, 4.5);
              Estudiante estudiante2 = new Estudiante(2, "María", "Gómez", "maria.gomez@email.com", "ES002", programa2, true, 4.8);

              // === Agregar profesores ===
              Profesor profesor1 = new Profesor(1, "Carlos", "Rodríguez", "carlos.rodriguez@email.com", "Tiempo Completo");
              Profesor profesor2 = new Profesor(2, "Ana", "Martínez", "ana.martinez@email.com", "Medio Tiempo");

              // === Agregar cursos ===
              Curso curso1 = new Curso(1, "Programación Avanzada", programa1, true);
              Curso curso2 = new Curso(2, "Principios de Finanzas", programa2, true);

              // === Agregar inscripciones de cursos ===
              Inscripcion inscripcion1 = new Inscripcion(1, curso1, 2023, 2, estudiante1);
              Inscripcion inscripcion2 = new Inscripcion(2, curso2, 2023, 2, estudiante2);

              cursosInscritos.inscribirCurso(inscripcion1);
              cursosInscritos.inscribirCurso(inscripcion2);

              // === Agregar asignación de profesores a cursos ===
              CursoProfesor cursoProfesor1 = new CursoProfesor(1, profesor1, 2023, 2, curso1);
              CursoProfesor cursoProfesor2 = new CursoProfesor(2, profesor2, 2023, 2, curso2);

              cursosProfesores.inscribir(cursoProfesor1);
              cursosProfesores.inscribir(cursoProfesor2);

              // === Agregar personas (para ejemplo incluye estudiantes y profesores) ===
              inscripcionesPersonas.inscribir(estudiante1);
              inscripcionesPersonas.inscribir(estudiante2);
              inscripcionesPersonas.inscribir(profesor1);
              inscripcionesPersonas.inscribir(profesor2);

              // Nota: Los datos al inscribir se guardan automáticamente en sus respectivos archivos de texto.
       }
}