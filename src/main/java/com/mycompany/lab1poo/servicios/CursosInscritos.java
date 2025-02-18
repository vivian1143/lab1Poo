package com.mycompany.lab1poo.servicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.Curso;
import modelo.Estudiante;
import modelo.Inscripcion;

public class CursosInscritos {

    
    private List<Inscripcion> listado;
    
    private static final String ARCHIVO_CURSOS_INSCRITOS = "cursos_inscritos.txt";

    
    public CursosInscritos() {
        listado = new ArrayList<>();
        cargarDatos();
    }

    
    public void inscribirCurso(Inscripcion inscripcion) {
        listado.add(inscripcion);
        guardarInformacion(inscripcion);
    }

    
    public boolean eliminar(Inscripcion inscripcion) {
        boolean removed = listado.removeIf(i -> i.getIdInscripcion() == inscripcion.getIdInscripcion());
        if (removed) {
            guardarTodoListado();
        }
        return removed;
    }

    
    public boolean actualizar(Inscripcion inscripcion) {
        for (int i = 0; i < listado.size(); i++) {
            if (listado.get(i).getIdInscripcion() == inscripcion.getIdInscripcion()) {
                listado.set(i, inscripcion);
                guardarTodoListado();
                return true;
            }
        }
        return false;
    }

    
    public void guardarInformacion(Inscripcion inscripcion) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_CURSOS_INSCRITOS, true))) {
            Estudiante estudiante = inscripcion.getEstudiante();
            Curso curso = inscripcion.getCurso();
            String linea = inscripcion.getIdInscripcion() + ";" +
                           estudiante.getId() + ";" +
                           estudiante.getNombre() + ";" +
                           estudiante.getDocumento() + ";" +
                           estudiante.getCodigoEstudiante() + ";" +
                           curso.getId() + ";" +
                           curso.getNombre() + ";" +
                           curso.getCreditos() + ";" +
                           inscripcion.getSemestre();
            bw.write(linea);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar la inscripción: " + e.getMessage());
        }
    }

    
    private void guardarTodoListado() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_CURSOS_INSCRITOS))) {
            for (Inscripcion inscripcion : listado) {
                Estudiante estudiante = inscripcion.getEstudiante();
                Curso curso = inscripcion.getCurso();
                String linea = inscripcion.getIdInscripcion() + ";" +
                               estudiante.getId() + ";" +
                               estudiante.getNombre() + ";" +
                               estudiante.getDocumento() + ";" +
                               estudiante.getCodigoEstudiante() + ";" +
                               curso.getId() + ";" +
                               curso.getNombre() + ";" +
                               curso.getCreditos() + ";" +
                               inscripcion.getSemestre();
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el listado completo: " + e.getMessage());
        }
    }

    
    public void cargarDatos() {
        listado.clear();
        File file = new File(ARCHIVO_CURSOS_INSCRITOS);
        if (!file.exists()) {
            // Si el archivo no existe, no hay datos que cargar.
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 9) {
                    int idInscripcion = Integer.parseInt(partes[0]);
                    int idEstudiante = Integer.parseInt(partes[1]);
                    String nombreEstudiante = partes[2];
                    String documentoEstudiante = partes[3];
                    String codigoEstudiante = partes[4];
                    int idCurso = Integer.parseInt(partes[5]);
                    String nombreCurso = partes[6];
                    int creditosCurso = Integer.parseInt(partes[7]);
                    String semestre = partes[8];

                    // Se crean los objetos necesarios
                    Estudiante estudiante = new Estudiante(idEstudiante, nombreEstudiante, documentoEstudiante, codigoEstudiante);
                    Curso curso = new Curso(idCurso, nombreCurso, creditosCurso);
                    // Se asume que la clase Inscripcion tiene un constructor que recibe el id
                    Inscripcion inscripcion = new Inscripcion(idInscripcion, estudiante, curso, semestre);
                    listado.add(inscripcion);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar los datos de inscripciones: " + e.getMessage());
        }
    }

    /**
     * Retorna una representación en cadena de todas las inscripciones del listado.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Inscripcion inscripcion : listado) {
            sb.append(inscripcion.toString()).append("\n");
        }
        return sb.toString();
    }

    // (Opcional) Getter para acceder al listado completo desde otras clases.
    public List<Inscripcion> getListado() {
        return listado;
    }
}

