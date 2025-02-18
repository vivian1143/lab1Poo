// Suggested code may be subject to a license. Learn more: ~LicenseLog:3873768570.
package com.mycompany.lab1poo.servicios;


import com.mycompany.lab1poo.modelos.Estudiante;
import com.mycompany.lab1poo.modelos.Profesor;
import com.mycompany.lab1poo.modelos.Persona;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InscripcionesPersonas {

    
    private List<Persona> listado;
    
    private static final String ARCHIVO_INSCRIPCIONES_PERSONAS = "inscripciones_personas.txt";

    
    public InscripcionesPersonas() {
        listado = new ArrayList<>();
        cargarDatos();
    }

    
    public void inscribir(Persona p) {
        listado.add(p);
        guardarInformacion(p);
    }

    
    public boolean eliminar(Persona p) {
        boolean removed = listado.removeIf(persona -> persona.getId() == p.getId());
        if (removed) {
            // Reescribe el archivo con la lista actualizada
            guardarTodoListado();
        }
        return removed;
    }

    
    public boolean actualizar(Persona p) {
        for (int i = 0; i < listado.size(); i++) {
            if (listado.get(i).getId() == p.getId()) {
                listado.set(i, p);
                guardarTodoListado();
                return true;
            }
        }
        return false;
    }

    
    public void guardarInformacion(Persona p) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_INSCRIPCIONES_PERSONAS, true))) {
            String linea;
            if (p instanceof Estudiante) {
                Estudiante e = (Estudiante) p;
                linea = "E;" + e.getId() + ";" + e.getNombre() + ";" + e.getDocumento() + ";" + e.getCodigoEstudiante();
            } else if (p instanceof Profesor) {
                Profesor pr = (Profesor) p;
                linea = "P;" + pr.getId() + ";" + pr.getNombre() + ";" + pr.getDocumento() + ";" + pr.getCodigoProfesor();
            } else {
                // Si se llegara a tener otro tipo, se puede manejar de otra forma.
                linea = "U;" + p.getId() + ";" + p.getNombre() + ";" + p.getDocumento();
            }
            bw.write(linea);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar la información de la persona: " + e.getMessage());
        }
    }

    
    private void guardarTodoListado() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_INSCRIPCIONES_PERSONAS))) {
            for (Persona p : listado) {
                String linea;
                if (p instanceof Estudiante) {
                    Estudiante e = (Estudiante) p;
                    linea = "E;" + e.getId() + ";" + e.getNombre() + ";" + e.getDocumento() + ";" + e.getCodigoEstudiante();
                } else if (p instanceof Profesor) {
                    Profesor pr = (Profesor) p;
                    linea = "P;" + pr.getId() + ";" + pr.getNombre() + ";" + pr.getDocumento() + ";" + pr.getCodigoProfesor();
                } else {
                    linea = "U;" + p.getId() + ";" + p.getNombre() + ";" + p.getDocumento();
                }
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el listado de personas: " + e.getMessage());
        }
    }

    /**
     * Carga los datos desde el archivo de texto y reconstruye el listado en memoria.
     * Se asume el formato:
     * Tipo;id;nombre;documento;campoExtra
     * Donde Tipo es 'E' para Estudiante y 'P' para Profesor.
     */
    public void cargarDatos() {
        listado.clear();
        File file = new File(ARCHIVO_INSCRIPCIONES_PERSONAS);
        if (!file.exists()) {
            // Si el archivo no existe, no hay nada que cargar
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length >= 4) {
                    String tipo = partes[0];
                    int id = Integer.parseInt(partes[1]);
                    String nombre = partes[2];
                    String documento = partes[3];
                    if ("E".equalsIgnoreCase(tipo) && partes.length == 5) {
                        String codigoEstudiante = partes[4];
                        listado.add(new Estudiante(id, nombre, documento, codigoEstudiante));
                    } else if ("P".equalsIgnoreCase(tipo) && partes.length == 5) {
                        String codigoProfesor = partes[4];
                        listado.add(new Profesor(id, nombre, documento, codigoProfesor));
                    }
                    // Puedes agregar más casos si existen otros tipos.
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar datos de personas: " + e.getMessage());
        }
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Persona p : listado) {
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }

    // (Opcional) Getter para acceder al listado desde otras clases
    public List<Persona> getListado() {
        return listado;
    }
}

