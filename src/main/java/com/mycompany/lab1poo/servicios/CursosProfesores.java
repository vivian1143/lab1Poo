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
import modelo.CursoProfesor;
import modelo.Profesor;

public class CursosProfesores {

    // Listado de CursoProfesor
    private List<CursoProfesor> listado;
    
    private static final String ARCHIVO_CURSOS_PROFESORES = "cursos_profesores.txt";

    
    public CursosProfesores() {
        listado = new ArrayList<>();
        cargarDatos();
    }

    
    public void inscribir(CursoProfesor cp) {
        listado.add(cp);
    }

    
    public void guardarInformacion(CursoProfesor cp) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_CURSOS_PROFESORES, true))) {
            Curso curso = cp.getCurso();
            Profesor profesor = cp.getProfesor();
            // Formato: idCurso;nombreCurso;creditosCurso;idProfesor;nombreProfesor;documentoProfesor;codigoProfesor
            String linea = curso.getId() + ";" + curso.getNombre() + ";" + curso.getCreditos() + ";"
                         + profesor.getId() + ";" + profesor.getNombre() + ";" + profesor.getDocumento() + ";" + profesor.getCodigoProfesor();
            bw.write(linea);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar la información: " + e.getMessage());
        }
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (CursoProfesor cp : listado) {
            sb.append(cp.toString()).append("\n");
        }
        return sb.toString();
    }

    
    //Carga los datos almacenados en el archivo de texto al listado en memoria.
    public void cargarDatos() {
        listado.clear();
        File file = new File(ARCHIVO_CURSOS_PROFESORES);
        if (!file.exists()) {
            // Si el archivo no existe, no hay nada que cargar
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Se espera el formato: idCurso;nombreCurso;creditosCurso;idProfesor;nombreProfesor;documentoProfesor;codigoProfesor
                String[] partes = linea.split(";");
                if (partes.length == 7) {
                    int idCurso = Integer.parseInt(partes[0]);
                    String nombreCurso = partes[1];
                    int creditos = Integer.parseInt(partes[2]);

                    int idProfesor = Integer.parseInt(partes[3]);
                    String nombreProfesor = partes[4];
                    String documentoProfesor = partes[5];
                    String codigoProfesor = partes[6];

                    Curso curso = new Curso(idCurso, nombreCurso, creditos);
                    Profesor profesor = new Profesor(idProfesor, nombreProfesor, documentoProfesor, codigoProfesor);
                    CursoProfesor cp = new CursoProfesor(curso, profesor);
                    listado.add(cp);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar los datos: " + e.getMessage());
        }
    }

    // (Opcional) Getter para acceder al listado desde otras clases
    public List<CursoProfesor> getListado() {
        return listado;
    }
}
