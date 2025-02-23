package com.mycompany.lab1poo.servicios;

import com.mycompany.lab1poo.modelos.Persona;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InscripcionesPersonas implements Servicios {
    private List<Persona> listado = new ArrayList<>();

    public void inscribir(Persona persona) {
        listado.add(persona);
        guardarInformacion(persona);
    }

    public void eliminar(Persona persona) {
        listado.remove(persona);
        guardarInformacion(null);
    }

    public void actualizar(Persona persona) {
        for (int i = 0; i < listado.size(); i++) {
            if (listado.get(i).getIdPersona() == persona.getIdPersona()) {
                listado.set(i, persona);
                break;
            }
        }
        guardarInformacion(null);
    }

    public void guardarInformacion(Persona persona) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("personas.txt", true))) {
            if (persona != null) {
                writer.write(persona.toString());
                writer.newLine();
            } else {
                // Reescribir archivo
                try (BufferedWriter overwriteWriter = new BufferedWriter(new FileWriter("personas.txt"))) {
                    for (Persona per : listado) {
                        overwriteWriter.write(per.toString());
                        overwriteWriter.newLine();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarDatos() {
        listado.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("personas.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Parsear y reconstruir el objeto Persona desde la línea
                System.out.println("Carga de datos: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String imprimirPosicion(int posicion) {
        return listado.get(posicion).toString();
    }

    @Override
    public int cantidadActual() {
        return listado.size();
    }

    @Override
    public List<String> imprimirListado() {
        List<String> listadoStrings = new ArrayList<>();
        for (Persona persona : listado) {
            listadoStrings.add(persona.toString());
        }
        return listadoStrings;
    }
}