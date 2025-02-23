package com.mycompany.lab1poo.servicios;

import com.mycompany.lab1poo.modelos.CursoProfesor;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CursosProfesores implements Servicios {
    private List<CursoProfesor> listado = new ArrayList<>();

    public void inscribir(CursoProfesor cursoProfesor) {
        listado.add(cursoProfesor);
        guardarInformacion(cursoProfesor);
    }

    public void guardarInformacion(CursoProfesor cursoProfesor) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("cursos_profesores.txt", true))) {
            if (cursoProfesor != null) {
                writer.write(cursoProfesor.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarDatos() {
        listado.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("cursos_profesores.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Parsear y reconstruir el objeto CursoProfesor desde la línea
                System.out.println("Carga de datos: " + line);
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
        for (CursoProfesor cursoProfesor : listado) {
            listadoStrings.add(cursoProfesor.toString());
        }
        return listadoStrings;
    }
}