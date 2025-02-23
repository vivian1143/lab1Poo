package com.mycompany.lab1poo.servicios;

import com.mycompany.lab1poo.modelos.Inscripcion;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CursosInscritos implements Servicios {
    private List<Inscripcion> listado = new ArrayList<>();

    public void inscribirCurso(Inscripcion inscripcion) {
        listado.add(inscripcion);
        guardarInformacion(inscripcion);
    }

    public void eliminar(Inscripcion inscripcion) {
        listado.remove(inscripcion);
        cargarDatos(); // Actualiza la lista tras eliminación
    }

    public void actualizar(Inscripcion inscripcion) {
        for (int i = 0; i < listado.size(); i++) {
            if (listado.get(i).getIdInscripcion() == inscripcion.getIdInscripcion()) {
                listado.set(i, inscripcion);
                break;
            }
        }
        guardarInformacion(null);
    }

    public void guardarInformacion(Inscripcion inscripcion) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("inscripciones.txt", true))) {
            if (inscripcion != null) {
                writer.write(inscripcion.toString());
                writer.newLine();
            } else {
                // Reescribe el archivo al actualizar la información
                try (BufferedWriter overwriteWriter = new BufferedWriter(new FileWriter("inscripciones.txt"))) {
                    for (Inscripcion insc : listado) {
                        overwriteWriter.write(insc.toString());
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
        try (BufferedReader reader = new BufferedReader(new FileReader("inscripciones.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Aquí parsea según el formato de Inscripcion guardado
                System.out.println("Carga de datos: " + line); // Depuración, parsear según sea necesario
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return listado.toString();
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
        for (Inscripcion insc : listado) {
            listadoStrings.add(insc.toString());
        }
        return listadoStrings;
    }
}