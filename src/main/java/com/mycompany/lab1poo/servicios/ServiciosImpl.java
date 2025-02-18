package com.mycompany.lab1poo.servicios;

package servicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.Curso;
import modelo.CursoProfesor;
import modelo.Estudiante;
import modelo.Inscripcion;
import modelo.Profesor;

public class ServiciosImpl implements IServicios {

    // Rutas de archivo (puedes cambiarlas según tu preferencia)
    private static final String ARCHIVO_CURSO_PROFESOR = "curso_profesor.txt";
    private static final String ARCHIVO_INSCRIPCIONES = "inscripciones.txt";

    private List<CursoProfesor> listaCursoProfesor;
    private List<Inscripcion> listaInscripciones;

    public ServiciosImpl() {
        // Inicializa listas
        this.listaCursoProfesor = new ArrayList<>();
        this.listaInscripciones = new ArrayList<>();

        // Al crear el servicio, cargamos los datos existentes desde los archivos
        cargarDatos();
    }

    @Override
    public void inscribirCursoProfesor(Profesor profesor, Curso curso) {
        CursoProfesor cp = new CursoProfesor(curso, profesor);
        listaCursoProfesor.add(cp);
        System.out.println("Profesor " + profesor.getNombre() + " asignado al curso " + curso.getNombre());
    }

    @Override
    public void inscribirEstudianteEnCurso(Estudiante estudiante, Curso curso, String semestre) {
        Inscripcion insc = new Inscripcion(estudiante, curso, semestre);
        listaInscripciones.add(insc);
        System.out.println("Estudiante " + estudiante.getNombre() + " inscrito en el curso " + curso.getNombre());
    }

    @Override
    public boolean eliminarInscripcion(int idInscripcion) {
        for (Inscripcion ins : listaInscripciones) {
            if (ins.getIdInscripcion() == idInscripcion) {
                listaInscripciones.remove(ins);
                System.out.println("Inscripción con ID " + idInscripcion + " eliminada.");
                return true;
            }
        }
        System.out.println("No se encontró inscripción con ID " + idInscripcion);
        return false;
    }

    @Override
    public boolean actualizarInscripcion(int idInscripcion, String nuevoSemestre) {
        for (Inscripcion ins : listaInscripciones) {
            if (ins.getIdInscripcion() == idInscripcion) {
                ins.setSemestre(nuevoSemestre);
                System.out.println("Inscripción con ID " + idInscripcion + " actualizada al semestre " + nuevoSemestre);
                return true;
            }
        }
        System.out.println("No se encontró inscripción con ID " + idInscripcion);
        return false;
    }

    /**
     * Guarda los datos de listaCursoProfesor y listaInscripciones en los archivos de texto.
     */
    @Override
    public void guardarDatos() {
        guardarCursoProfesor();
        guardarInscripciones();
        System.out.println("Datos guardados en archivos de texto.");
    }

    /**
     * Carga los datos desde los archivos de texto a las listas en memoria.
     */
    @Override
    public void cargarDatos() {
        cargarCursoProfesor();
        cargarInscripciones();
        System.out.println("Datos cargados desde archivos de texto.");
    }

    // =================== Métodos privados para guardar/cargar ===================

    private void guardarCursoProfesor() {
        File file = new File(ARCHIVO_CURSO_PROFESOR);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (CursoProfesor cp : listaCursoProfesor) {
                Curso c = cp.getCurso();
                Profesor p = cp.getProfesor();
                // Formato: idCurso;nombreCurso;creditosCurso;idProfesor;nombreProfesor;documentoProfesor;codigoProfesor
                String linea = c.getId() + ";" + c.getNombre() + ";" + c.getCreditos() + ";"
                             + p.getId() + ";" + p.getNombre() + ";" + p.getDocumento() + ";" + p.getCodigoProfesor();
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error guardando curso_profesor.txt: " + e.getMessage());
        }
    }

    private void guardarInscripciones() {
        File file = new File(ARCHIVO_INSCRIPCIONES);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (Inscripcion ins : listaInscripciones) {
                // idInscripcion;idEst;nomEst;docEst;codEst;idCurso;nomCurso;credCurso;semestre
                int idInscripcion = ins.getIdInscripcion();
                Estudiante est = ins.getEstudiante();
                Curso c = ins.getCurso();
                String linea = idInscripcion + ";" 
                             + est.getId() + ";" + est.getNombre() + ";" + est.getDocumento() + ";" + est.getCodigoEstudiante() + ";"
                             + c.getId() + ";" + c.getNombre() + ";" + c.getCreditos() + ";"
                             + ins.getSemestre();
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error guardando inscripciones.txt: " + e.getMessage());
        }
    }

    private void cargarCursoProfesor() {
        listaCursoProfesor.clear(); // Limpia la lista antes de cargar

        File file = new File(ARCHIVO_CURSO_PROFESOR);
        if (!file.exists()) {
            // Si el archivo no existe, no hacemos nada.
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Formato: idCurso;nombreCurso;creditosCurso;idProfesor;nombreProfesor;documentoProfesor;codigoProfesor
                String[] partes = linea.split(";");
                if (partes.length == 7) {
                    int idCurso = Integer.parseInt(partes[0]);
                    String nombreCurso = partes[1];
                    int creditos = Integer.parseInt(partes[2]);

                    int idProfesor = Integer.parseInt(partes[3]);
                    String nombreProfesor = partes[4];
                    String documentoProfesor = partes[5];
                    String codigoProfesor = partes[6];

                    Curso c = new Curso(idCurso, nombreCurso, creditos);
                    Profesor p = new Profesor(idProfesor, nombreProfesor, documentoProfesor, codigoProfesor);

                    CursoProfesor cp = new CursoProfesor(c, p);
                    listaCursoProfesor.add(cp);
                }
            }
        } catch (IOException e) {
            System.out.println("Error cargando curso_profesor.txt: " + e.getMessage());
        }
    }

    private void cargarInscripciones() {
        listaInscripciones.clear(); // Limpia la lista antes de cargar

        File file = new File(ARCHIVO_INSCRIPCIONES);
        if (!file.exists()) {
            // Si el archivo no existe, no hacemos nada.
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Formato: idInsc;idEst;nomEst;docEst;codEst;idCurso;nomCurso;credCurso;semestre
                String[] partes = linea.split(";");
                if (partes.length == 9) {
                    int idInsc = Integer.parseInt(partes[0]);

                    int idEst = Integer.parseInt(partes[1]);
                    String nomEst = partes[2];
                    String docEst = partes[3];
                    String codEst = partes[4];

                    int idCurso = Integer.parseInt(partes[5]);
                    String nombreCurso = partes[6];
                    int creditosCurso = Integer.parseInt(partes[7]);

                    String semestre = partes[8];

                    Estudiante estudiante = new Estudiante(idEst, nomEst, docEst, codEst);
                    Curso curso = new Curso(idCurso, nombreCurso, creditosCurso);

                    // Usamos el constructor de Inscripcion que recibe ID para mantener la consistencia
                    Inscripcion ins = new Inscripcion(idInsc, estudiante, curso, semestre);
                    listaInscripciones.add(ins);
                }
            }
        } catch (IOException e) {
            System.out.println("Error cargando inscripciones.txt: " + e.getMessage());
        }
    }

    // Método extra para listar inscripciones en consola (ejemplo)
    public void listarInscripciones() {
        if (listaInscripciones.isEmpty()) {
            System.out.println("No hay inscripciones registradas.");
        } else {
            for (Inscripcion i : listaInscripciones) {
                System.out.println(i);
            }
        }
    }

    // Método extra para listar curso-profesor en consola (ejemplo)
    public void listarCursoProfesor() {
        if (listaCursoProfesor.isEmpty()) {
            System.out.println("No hay asignaciones de curso-profesor registradas.");
        } else {
            for (CursoProfesor cp : listaCursoProfesor) {
                System.out.println(cp);
            }
        }
    }
}

